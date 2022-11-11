package fr.pantheonsorbonne.miage;

import java.util.*;

import fr.pantheonsorbonne.miage.exceptions.NoMoreCardsException;
import fr.pantheonsorbonne.miage.game.Card;
import fr.pantheonsorbonne.miage.game.Deck;
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
    private final Game president;
    private String firstPlayer;

    /*
     * storing the players name in a list
     * wil be use when roles will be displayed
     */
    private final List<String> players;
    /*
     * winners needs to be a LinkedHashSet so we can keep the seizure order
     * this will help when roles will be displayed
     */
    private final List<String> winners = new ArrayList<>();

    /* playersStillPlaying keeps the players name and the play order */
    private final Set<String> playersStillPlaying = new LinkedHashSet<>();

    public PresidentGameNetworkEngine(HostFacade hostFacade, Game president) {
        this.hostFacade = hostFacade;
        this.players = new ArrayList<>(president.getPlayers());
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
        handleResponseToQueenOfHeart();
        // start loop : ask for every players to play
        // end of the loop
        // display roles
        // giveCards
        // exchangeCards
        // start the same loop as before
        // gameOver
        gameOver();

    }

    /*
     * parent method should be implement in PresidentGameEngine (check teacher's
     * example)
     */
    protected Set<String> getNamePlayers() {
        return this.president.getPlayers();
    }

    /* give cards to each player */
    protected void giveCardsToPlayers(Game president, Deck deck) {
        int nbCards = deck.getDeckSize() / president.getPlayers().size();
        for (String playerName : president.getPlayers()) {
            Card[] cardsToGive = deck.giveCards(nbCards);
            String cardsString = Card.cardsToString(cardsToGive);
            hostFacade.sendGameCommandToPlayer(president, playerName, new GameCommand("cardsForYou", cardsString));
        }
    }

    /* check who has the queen of heart */
    //TO DO for each player 
    protected void handleResponseToQueenOfHeart(){
        GameCommand command = hostFacade.receiveGameCommand(president);
        if ("responseToQueenOfHeart".equals(command.name())){
            String[] bodyContent = command.body().split(":");
            if ("yes".equals(bodyContent[1])){
                System.out.println(bodyContent[0]+" starts the game");
            }
        }
        //reorder the list
    }

    /* storing the name of the first player */
    protected void setFirstPlayer(String playerName) {
        this.firstPlayer = playerName;
        System.out.println("The first player is " + firstPlayer);
    }

    protected String getFirstPlayer(){
        return firstPlayer;
    }

    /* the host designates who's the next player and sends him the cards played */
    protected void plays(Card[] cards) {
        System.out.println("it's your turn ! Here the cards played before :" + Arrays.toString(cards));
    }

    /* winners will be used while displaying the roles */
    protected void addWinners(String playerName) {
        winners.add(playerName);
    }

    /*
     * telling which players still in the game -> will help saying that the sleeve
     * is over when there's one player left
     */
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
     * <p>
     * If the player has no more card, throw an exception
     *
     * @param player the name of the player
     * @return a card from a player
     * @throws NoMoreCardException if player has no more card.
     */
    @Override
    protected Card getCardFromPlayer(String player) throws NoMoreCardsException {
        hostFacade.sendGameCommandToPlayer(president, player, new GameCommand("playACard"));
        GameCommand expectedCard = hostFacade.receiveGameCommand(president);
        if (expectedCard.name().equals("card")) {
            return Card.valueOf(expectedCard.body());
        }
        if (expectedCard.name().equals("outOfCard")) {
            throw new NoMoreCardsException();
        }
        //should not happen!
        throw new RuntimeException("invalid state");

    }
}