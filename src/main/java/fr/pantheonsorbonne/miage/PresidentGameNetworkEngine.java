package fr.pantheonsorbonne.miage;

import java.util.*;

import fr.pantheonsorbonne.miage.game.Card;
import fr.pantheonsorbonne.miage.game.Deck;
import fr.pantheonsorbonne.miage.game.PlayerResponse;
import fr.pantheonsorbonne.miage.model.Game;
import fr.pantheonsorbonne.miage.model.GameCommand;

/**
 * This class implements the war game with the network engine
 */
public class PresidentGameNetworkEngine {
    /* by default, the game is with 4 players */
    private static final int PLAYER_COUNT = 4;
    private static int nbPlayers;

    private final HostFacade hostFacade;
    protected final Game president;
    private String firstPlayer;

    /*
     * storing the players name in a list
     * wil be use when roles will be displayed
     */
    private final List<String> players = new ArrayList<>();
    /*
     * winners needs to be a LinkedHashSet so we can keep the seizure order
     * this will help when roles will be displayed
     */
    private final List<String> winners = new ArrayList<>();

    /* playersStillPlaying keeps the players name and the play order */
    private final Set<String> playersStillPlaying = new LinkedHashSet<>();

    public PresidentGameNetworkEngine(HostFacade hostFacade, Game president) {
        this.hostFacade = hostFacade;
        this.president = president;
    }

    public static boolean isInitPlayers(String[] args) {
        if (args == null) {
            nbPlayers = PLAYER_COUNT;
            return true;
        }
        if (args.length >= 1) {
            try {
                nbPlayers = Integer.parseInt(args[0]);
                if (nbPlayers >= 4 && nbPlayers <= 6) {
                    return true;
                } else {
                    System.err.println("Invalid number of players, it must be between 4 and 6");
                    return false;
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid number of players");
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        if (!isInitPlayers(args)) {
            System.exit(0);
        }
        // create the host facade
        HostFacade hostFacade = Facade.getFacade();
        hostFacade.waitReady();

        // set the name of the player
        hostFacade.createNewPlayer("Host");
        // create a new game of president
        Game president = hostFacade.createNewGame("PRESIDENT");

        // wait for enough players to join
        hostFacade.waitForExtraPlayerCount(nbPlayers);

        PresidentGameNetworkEngine host = new PresidentGameNetworkEngine(hostFacade, president);
        host.play();
    }

    protected void play() {
        // giveCards
        Deck deck = new Deck();
        giveCardsToPlayers(president, deck);
        // check who has the Queen of heart (wait all responses) -> reorder players list
        System.out.println("Who has the queen of heart ?");
        handleResponseToQueenOfHeart();
        // start loop : ask for every players to play, show the cards played before the player's turn, check if the card can be played
        while (playersStillPlaying.size() >= 1){
            for (String player : getPlayers()){
                getCardFromPlayer(player);
            }
        }
        // end of the loop
        // display roles
        // giveCards
        giveCardsToPlayers(president, deck);
        // exchangeCards
        // start the same loop as before
        // end of the game :
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
        for (String playerName : president.getPlayers()) {
            Card[] cardsToGive = deck.giveCards(nbCards);
            String cardsString = Card.cardsToString(cardsToGive);
            hostFacade.sendGameCommandToPlayer(president, playerName, new GameCommand("cardsForYou", cardsString));
        }
    }

    /** check who has the queen of heart */
    protected void handleResponseToQueenOfHeart(){
        List<String> otherPlayers = new ArrayList<>();
        for (int i=0; i<nbPlayers; i++){
            GameCommand command = hostFacade.receiveGameCommand(president);
            if ("responseToQueenOfHeart".equals(command.name())){
                String[] bodyContent = command.body().split(":");
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


    /** storing the name of the first player */
    protected void setFirstPlayer(String playerName) {
        this.firstPlayer = playerName;
        System.out.println("The first player is " + firstPlayer);
    }

    protected String getFirstPlayer(){
        return firstPlayer;
    }

    /** the host designates who's the next player and sends him the cards played */
    protected void plays(Card[] cards) {
        System.out.println("it's your turn ! Here the cards played before :" + Arrays.toString(cards));
    }

    /** winners will be used while displaying the roles */
    protected void addWinners(String playerName) {
        winners.add(playerName);
    }

    /** telling which players still in the game -> will help saying that the sleeve
     * is over when there's one player left */
    private void playersInTheGame(Set<String> playersStillPlaying) {
        System.out.println("players still playing " + playersStillPlaying.toString());
    }

    /* reset the card set if a sleeve is over */
    protected void reset(Card[] cards) {
        for (int i = 0; i < cards.length; i++) {
            cards[i] = null;
        }
    }

    /* displaying the roles and initiating the cards exchange */
    protected void displayRoles(String[] winners, int nbCards, String type, int position) {

        System.out.println(
                winners[position] + " has to give his/her " + type + "cards to " + winners[winners.length - position]);
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
        hostFacade.sendGameCommandToPlayer(president, player, new GameCommand("play"));
        GameCommand receivedCard = hostFacade.receiveGameCommand(president);
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

    public List<String> getPlayers() {
        return this.players;
    }
}