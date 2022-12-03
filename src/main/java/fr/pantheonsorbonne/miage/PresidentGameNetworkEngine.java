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
public class PresidentGameNetworkEngine extends PresidentGameEngine{

    private final HostFacade hostFacade;

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
            int nbPlayers = Integer.parseInt(nbPlayersStr);
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
            int nbRounds = Integer.parseInt(nbRoundsStr);
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
        int nbPlayers = Integer.parseInt(args[0]);
        int nbRounds = Integer.parseInt(args[1]);
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
        host.setNbPlayers(nbPlayers);
        host.setNbRounds(nbRounds);
        host.play();
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
        while (nbResponses < getNbPlayers()){
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
    public List<String> getPlayers() {
        return this.players;
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

      /**
     * we get a card from a player, if possible.
     * @param player the name of the player
     * @return card(s) from a player, and the number of remaining cards
     */
    @Override
    public PlayerResponse getCardFromPlayer(String player){
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
}