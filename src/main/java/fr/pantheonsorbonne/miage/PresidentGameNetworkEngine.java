package fr.pantheonsorbonne.miage;

import java.util.*;

import fr.pantheonsorbonne.miage.enums.CardValue;
import fr.pantheonsorbonne.miage.game.Card;
import fr.pantheonsorbonne.miage.game.Deck;
import fr.pantheonsorbonne.miage.game.PlayerResponse;
import fr.pantheonsorbonne.miage.model.Game;
import fr.pantheonsorbonne.miage.model.GameCommand;

/**
 * This class implements the war game with the network engine
 */
public class PresidentGameNetworkEngine {
    private static int nbPlayers;
    private static int nbRounds;

    private final HostFacade hostFacade;
    protected final Game president;
    private Deck deck = null;
    private String firstPlayer;
    private boolean endsWithTwo = false; 
    private boolean isPresident = false;
    private String closedPlayer = "";

    private Deque<Card[]> lastNMoves = new ArrayDeque<>();
    private Map<CardValue, Integer> squareCounter = new HashMap<>();

    /*
     * storing the players name in a list
     * wil be use when roles will be displayed
     */
    private final List<String> players = new ArrayList<>();
    /*
     * winners needs to be a LinkedHashSet so we can keep the seizure order
     * this will help when roles will be displayed
     */
    private final Deque<String> winners = new ArrayDeque<>();

    /* playersStillPlaying keeps the players name and the play order */
    private final Set<String> playersStillPlaying = new LinkedHashSet<>();

    public PresidentGameNetworkEngine(HostFacade hostFacade, Game president) {
        this.hostFacade = hostFacade;
        this.president = president;
    }

    public static boolean checkArgs(String[] args) {
        if (args.length == 2) {
            return checkNbPlayers(args[0]) && checkNbRounds(args[1]);
        }
        else {
            return false;
        }
    }

    private static boolean checkNbPlayers(String nbPlayersStr){
        try {
            nbPlayers = Integer.parseInt(nbPlayersStr);
            if (nbPlayers >= 4 && nbPlayers <= 6) {
                return true;
            } else {
                System.err.println("Invalid number of players, it must be between 4 and 6");
                return false;
            }
        } catch (NumberFormatException e) {
            System.err.println("Invalid number for nbPlayers");
            return false;
        }
    }

    private static boolean checkNbRounds(String nbRoundsStr){
        try {
            nbRounds = Integer.parseInt(nbRoundsStr);
            if (nbRounds >= 2 && nbRounds <= 10) {
                return true;
            } else {
                System.err.println("Invalid number of rounds, it must be between 2 and 10");
                return false;
            }
        } catch (NumberFormatException e) {
            System.err.println("Invalid number for nbRounds");
            return false;
        }
    }
        
    public static void main(String[] args) {
        if (!checkArgs(args)) {
            System.err.println("Usage : PresidentGameNetworkEngine [nbPlayers] [nbRounds]");
            System.exit(0);
        }
        // create the host facade
        HostFacade hostFacade = Facade.getFacade();
        hostFacade.waitReady();

        // set the name of the host
        hostFacade.createNewPlayer("Host");

        // create a new game of president
        Game president = hostFacade.createNewGame("PRESIDENT");

        // wait for enough players to join
        hostFacade.waitForExtraPlayerCount(nbPlayers+1);

        PresidentGameNetworkEngine host = new PresidentGameNetworkEngine(hostFacade, president);
        host.play();
    }

    protected void play() {
        deck = new Deck();
        giveCardsToPlayers(president, deck);
        // check who has the Queen of heart (wait all responses) -> reorder players list
        System.out.println("Who has the queen of heart ?");
        askForQueenOfHeart();
        handleResponseToQueenOfHeart();
        gameLoop();

        int cpt = 0;
        while (cpt < nbRounds -1){
            deck = new Deck();
            giveCardsToPlayers(president, deck);
            exchangeCards();
            gameLoop();
        }
        gameOver();

    }


    /*
     * parent method should be implement in PresidentGameEngine (check teacher's
     * example)
     */
    protected Set<String> getNamePlayers() {
        return this.president.getPlayers();
    }

    /** give cards to each player */
    protected void giveCardsToPlayers(Game president, Deck deck) {
        int nbCards = deck.getDeckSize() / president.getPlayers().size();
        for (String playerId : president.getPlayers()) {
            Card[] cardsToGive = deck.giveCards(nbCards);
            String cardsString = Card.cardsToString(cardsToGive);
            System.out.println(cardsString);
            hostFacade.sendGameCommandToPlayer(president, playerId, new GameCommand("cardsForYou", cardsString));
        }
    }

    private void askForQueenOfHeart() {
        GameCommand askForQueenOfHeart = new GameCommand("askForQueenOfHeart");
        hostFacade.sendGameCommandToAll(president, askForQueenOfHeart);
    }

    protected void handleResponseToQueenOfHeart(){
        List<String> otherPlayers = new ArrayList<>();
        int nbResponses = 0;
        while (nbResponses < nbPlayers){
            GameCommand command = hostFacade.receiveGameCommand(president);
            if ("responseToQueenOfHeart".equals(command.name())){
                nbResponses++;
                String[] bodyContent = command.body().split("=");
                if ("yes".equals(bodyContent[1])){
                    setFirstPlayer(bodyContent[0]);
                    players.add(bodyContent[0]);
                }
                else {
                    otherPlayers.add(bodyContent[0]);
                }
            }
        }
        players.addAll(otherPlayers);
    }

    private void gameLoop(){
        playersStillPlaying.addAll(players);
        while (playersStillPlaying.size() > 1){
            for (String player : getPlayers()){
                if(skipPlayerWhenClose(player)) {
                    continue;
                }
                if (playersStillPlaying.contains(player)){
                    playerPlay(player);
                }
            }
        }
        // end of while loop, playersStillPlaying should contains only one player (the last one)
        System.out.printf("playersStillPlaying.size() %d - [%s]%n", playersStillPlaying.size(), playersStillPlaying);
        winners.addAll(playersStillPlaying);
        if (!endsWithTwo){
            String scumbag = winners.pollLast();
            winners.addFirst(scumbag);
        }   
        System.out.println("order for new round : "+winners);
    }

    private boolean skipPlayerWhenClose(String player) {
        if (closedPlayer.isEmpty()){
            return false;
        } 
        else if(!player.equals(closedPlayer)){
            return true;
        }
        else{
            closedPlayer = "";
            return false;
        }
    }

    private void playerPlay(String player) {
        PlayerResponse response = getCardFromPlayer(player);
        updateLastNMoves(response);
        System.out.println("lastNmoves : ");
        lastNMoves.forEach(System.out::println);
        //check if the player ends his hand
        if (response.getNbOfCardsRemaining() == 0){
            //if the last card is a 2, the player is the Scumbag
            if (endsWithTwo()){
                System.out.println(player+" ends with two");
                winners.addFirst(player); 
                endsWithTwo = true;
            }
            else {
                System.out.println(player+" ends");
                addWinners(player);
            }
            playersStillPlaying.remove(player);

            //if he is the first player to finish : reset the pile 
            if (winners.size() == 1){
                isPresident = true;
            }
            System.out.println("winners.size : "+winners.size() + " playersStillPlaying.size(): " + playersStillPlaying.size());
        }
        //check if the serie is finished
        if (isClosed(isPresident)){
            System.out.println("round is closed");
            lastNMoves.clear();
            isPresident = false;
            closedPlayer = player;
        }  
    }

    private void updateLastNMoves(PlayerResponse response){
        lastNMoves.addFirst(response.getCards());
        if (lastNMoves.size() > nbPlayers){
            lastNMoves.removeLast();
        }
    }   

    /** storing the name of the first player */
    protected void setFirstPlayer(String playerId) {
        this.firstPlayer = playerId;
        System.out.println("The first player is " + getPlayerName(firstPlayer));
    }

    private String getPlayerName(String playerId) {
        return playerId.split("#")[0];
    }

    protected String getFirstPlayer(){
        return firstPlayer;
    }

    /** the host designates who's the next player and sends him the cards played */
    protected void plays(Card[] cards) {
        System.out.println("it's your turn ! Here the cards played before :" + Arrays.toString(cards));
    }

    /** winners will be used while displaying the roles */
    protected void addWinners(String playerId) {
        winners.add(playerId);
    }


    /* displaying the roles and initiating the cards exchange */
    protected void exchangeCards(){
        String scumbagName = winners.poll();
        String presidentName = winners.poll();
        String vicePresidentName = winners.poll();
        String viceScumbagName = winners.pollLast();

        System.out.printf("President (%s) and Scumbag (%s) exchange two cards\n", presidentName, scumbagName);
        GameCommand giveTwoBestCards = new GameCommand("giveBestCards", "2", Map.of("toPlayer", presidentName));
        hostFacade.sendGameCommandToPlayer(this.president, scumbagName, giveTwoBestCards);

        System.out.printf("Vice-President (%s) and Vice-Scumbag (%s) exchange one card\n", vicePresidentName, viceScumbagName);
        GameCommand giveYourBestCard = new GameCommand("giveBestCards", "1", Map.of("toPlayer", vicePresidentName));
        hostFacade.sendGameCommandToPlayer(this.president, viceScumbagName, giveYourBestCard);

        int nbResponses = 0;
        while (nbResponses < 2){
            GameCommand command = hostFacade.receiveGameCommand(president);
            if ("exchangeOk".equals(command.name())){
                nbResponses++;
            }
        }

        players.clear();
        players.addAll(winners);
        winners.clear();
    }

    private void gameOver() {
        System.out.println("End of the game");
        System.out.println("Winner is ?");
    }
      /**
     * we get a card from a player, if possible.
     * @param player the name of the player
     * @return card(s) from a player, and the number of remaining cards
     */
    protected PlayerResponse getCardFromPlayer(String player){
        hostFacade.sendGameCommandToPlayer(president, player, new GameCommand("play", getLastNMovesStr()));
        System.out.println("Ask "+player);
        GameCommand receivedCard = hostFacade.receiveGameCommand(president);
        System.out.println("receive card : "+receivedCard.body()+" params : "+receivedCard.params());
        if (receivedCard.name().equals("played")) {
            Card[] cards = Card.stringToCards(receivedCard.body());
            int nbRemainingCards = Integer.parseInt(receivedCard.params().get("nbcards"));
            return new PlayerResponse(cards, nbRemainingCards);
        }
        if (receivedCard.name().equals("canNotPlay")) {
            int nbRemainingCards = Integer.parseInt(receivedCard.params().get("nbcards"));
            return new PlayerResponse(new Card[0], nbRemainingCards); 
        }
        //should not happen!
        throw new RuntimeException("invalid state");

    }

    private String getLastNMovesStr() {
        StringJoiner lastMove = new StringJoiner("#");
        for(Card[] move : lastNMoves){
            lastMove.add(Card.cardsToString(move));
        }
        return lastMove.toString();
    }

    protected boolean isClosed(boolean isPresident){
        System.out.printf("endsWithTwo: %b - isSquare: %b - noOneCanPlay: %b - isPresident: %b%n", endsWithTwo(), isSquare(), noOneCanPlay(), isPresident);
        return endsWithTwo() || isSquare() || noOneCanPlay() || isPresident ;
    }

    protected boolean endsWithTwo(){
        if (lastNMoves.getFirst().length > 0){
            return CardValue.TWO.equals(lastNMoves.getFirst()[0].getValue());
        }
        return false;
    }

    protected boolean isSquare(){
        if (lastNMoves.getFirst().length > 0){
            CardValue cardValue = lastNMoves.getFirst()[0].getValue();
            Integer cpt = squareCounter.merge(cardValue, lastNMoves.getFirst().length, Integer::sum);
            return cpt == 4;
        }
        return false;
    }

     protected boolean noOneCanPlay(){
        int nb = 0;
        for (Card[] move : lastNMoves){
            if (nb<playersStillPlaying.size()){
                if (move.length != 0){
                    return false; 
                }
            }
            nb++;
        }
        return true;
    }

    public List<String> getPlayers() {
        return this.players;
    }
}