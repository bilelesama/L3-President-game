package fr.pantheonsorbonne.miage;

import java.util.*;

import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper;

import fr.pantheonsorbonne.miage.enums.CardValue;
import fr.pantheonsorbonne.miage.game.Card;
import fr.pantheonsorbonne.miage.game.Deck;
import fr.pantheonsorbonne.miage.game.PlayerResponse;
import fr.pantheonsorbonne.miage.model.Game;
import fr.pantheonsorbonne.miage.model.GameCommand;

/**
 * This class implements the war game with the network engine
 */
public class PresidentGameNetworkEngine extends PresidentGameEngine{
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
    private Map<String, Integer> presidentCounter = new HashMap<>();

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

    @Override
    public void play() {
        deck = new Deck();
        giveCardsToPlayers(president, deck);
        // check who has the Queen of heart (wait all responses) -> reorder players list
        System.out.println("Who has the queen of heart ?");
        askForQueenOfHeart();
        handleResponseToQueenOfHeart();
        gameLoop();
        System.out.println("end of first round");
        int cpt = 1;
        while (cpt < nbRounds){
            cpt++;
            deck = new Deck();
            giveCardsToPlayers(president, deck);
            resetListAndCounter();
            exchangeCards();
            gameLoop();
            System.out.println("end of round " + cpt);
        }
        gameOver();
    }


    private void resetListAndCounter() {
        players.clear();
        players.addAll(winners);
        playersStillPlaying.clear();
        squareCounter.clear();
    }

    /*
     * parent method should be implement in PresidentGameEngine (check teacher's
     * example)
     */
    protected Set<String> getNamePlayers() {
        return this.president.getPlayers();
    }

    /** give cards to each player */
    @Override
    public void giveCardsToPlayers(Game president, Deck deck) {
        int nbCards = deck.getDeckSize() / president.getPlayers().size();
        for (String playerId : president.getPlayers()) {
            Card[] cardsToGive = deck.giveCards(nbCards);
            String cardsString = Card.cardsToString(cardsToGive);
            System.out.println(cardsString);
            hostFacade.sendGameCommandToPlayer(president, playerId, new GameCommand("cardsForYou", cardsString));
        }
    }

    @Override
    public void askForQueenOfHeart() {
        GameCommand askForQueenOfHeart = new GameCommand("askForQueenOfHeart");
        hostFacade.sendGameCommandToAll(president, askForQueenOfHeart);
    }

    @Override
    public void handleResponseToQueenOfHeart(){
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

    @Override
    public void gameLoop(){
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
        lastNMoves.forEach(m -> System.out.println(Card.cardsToString(m)));
        updateSquareCounter();
        //check if the player ends his hand
        if (response.getNbOfCardsRemaining() == 0){
            //if the last card is a 2, the player is the Scumbag
            if (endsWithTwo()){
                System.out.println(getPlayerName(player)+" ends with two");
                winners.addFirst(player); 
                endsWithTwo = true;
            }
            else {
                System.out.println(getPlayerName(player)+" ends");
                addWinners(player);
            }
            playersStillPlaying.remove(player);

            //if he is the first player to finish : reset the pile 
            if (winners.size() == 1){
                isPresident = true;
                presidentCounter.merge(player, 1, Integer::sum);
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
    @Override
    public void setFirstPlayer(String playerId) {
        this.firstPlayer = playerId;
        System.out.println("The first player is " + getPlayerName(firstPlayer));
    }

    @Override
    public String getPlayerName(String playerId) {
        return playerId.split("#")[0];
    }

    @Override
    public String getFirstPlayer(){
        return firstPlayer;
    }

    /** winners will be used while displaying the roles */
    protected void addWinners(String playerId) {
        winners.add(playerId);
    }


    /* displaying the roles and initiating the cards exchange */
    @Override
    public void exchangeCards(){
        String scumbagName = winners.poll();
        String presidentName = winners.poll();
        String vicePresidentName = winners.poll();
        String viceScumbagName = winners.pollLast();

        System.out.printf("President (%s) and Scumbag (%s) exchange two cards\n", getPlayerName(presidentName), getPlayerName(scumbagName));
        GameCommand giveTwoBestCards = new GameCommand("giveBestCards", "2", Map.of("playerId", scumbagName, "toPlayer", presidentName));
        hostFacade.sendGameCommandToAll(this.president, giveTwoBestCards);

        System.out.printf("Vice-President (%s) and Vice-Scumbag (%s) exchange one card\n", getPlayerName(vicePresidentName), getPlayerName(viceScumbagName));
        GameCommand giveYourBestCard = new GameCommand("giveBestCards", "1", Map.of("playerId", viceScumbagName, "toPlayer", vicePresidentName));
        hostFacade.sendGameCommandToAll(this.president, giveYourBestCard);

        int nbResponses = 0;
        while (nbResponses < 2){
            GameCommand command = hostFacade.receiveGameCommand(president);
            if ("exchangeOk".equals(command.name())){
                nbResponses++;
            }
        }

        winners.clear();
    }

    @Override
    public void gameOver() {
        System.out.println("End of the game");
        displayWinner();
    }
      /**
     * we get a card from a player, if possible.
     * @param player the name of the player
     * @return card(s) from a player, and the number of remaining cards
     */
    protected PlayerResponse getCardFromPlayer(String player){
        hostFacade.sendGameCommandToPlayer(president, player, new GameCommand("play", getLastNMovesStr()));
        System.out.println("Ask "+getPlayerName(player));
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
        System.out.printf("endsWithTwo: %s - isSquare: %s - noOneCanPlay: %s - isPresident: %s%n", endsWithTwo(), isSquare(), noOneCanPlay(), isPresident);
        return endsWithTwo() || isSquare() || noOneCanPlay() || isPresident ;
    }

    protected boolean endsWithTwo(){
        if (lastNMoves.getFirst().length > 0){
            return CardValue.TWO.equals(lastNMoves.getFirst()[0].getValue());
        }
        return false;
    }

    protected void updateSquareCounter() {
        if (lastNMoves.getFirst().length > 0){
            CardValue cardValue = lastNMoves.getFirst()[0].getValue();
            squareCounter.merge(cardValue, lastNMoves.getFirst().length, Integer::sum);
        }
    }

    protected boolean isSquare(){
        if (lastNMoves.getFirst().length > 0){
            CardValue cardValue = lastNMoves.getFirst()[0].getValue();
            Integer cpt = squareCounter.get(cardValue);
            return cpt == 4;
        }
        return false;
    }

    protected boolean noOneCanPlay(){
        int nb = 0;
        for (Card[] move : lastNMoves){
            if (nb < playersStillPlaying.size() && move.length != 0){
                return false; 
            }
            nb++;
        }
        return true;
    }

    @Override
    public List<String> getPlayers() {
        return this.players;
    }

    protected void displayWinner(){
        int maxValue = 0;
        String winner = "";
        for (Map.Entry<String, Integer> entry : presidentCounter.entrySet()) {
            if (entry.getValue() > maxValue){
                maxValue = entry.getValue();
                winner = entry.getKey();
            }
        }
        System.out.printf("The winner is %s (was %d times president for the %d rounds played)%n", getPlayerName(winner), presidentCounter.get(winner), nbRounds);
    }
}