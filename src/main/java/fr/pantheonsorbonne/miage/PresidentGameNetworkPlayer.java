package fr.pantheonsorbonne.miage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

import fr.pantheonsorbonne.miage.enums.CardColor;
import fr.pantheonsorbonne.miage.enums.CardValue;
import fr.pantheonsorbonne.miage.game.Card;
import fr.pantheonsorbonne.miage.model.Game;
import fr.pantheonsorbonne.miage.model.GameCommand;

/**
 * this is the player part of the network version of the war game
 */
public class PresidentGameNetworkPlayer {

    static final int id = new Random().nextInt();
    static String playerName;
    static String playerId;
    static final List<Card> hand = new ArrayList<>();
    static final PlayerFacade playerFacade = Facade.getFacade();
    static Game president;
    static List<Card[]> lastNMoves = new ArrayList<>();
    static Guest guest;
    static boolean playing = true;

    public static void main(String[] args) {
        /* check if the player name is ok */
        if (args == null || args.length != 2){
            System.err.println("Usage : PresidentGameNetworkPlayer [playerName] [guest implementation]");
            System.exit(0);
        }
        playerFacade.waitReady();
        playerName = args[0];
        playerId = playerName+"#"+id;
        playerFacade.createNewPlayer(playerId);
        president = playerFacade.autoJoinGame("PRESIDENT");
        
        if ("GuestDummyImpl".equals(args[1])) {
            guest = new GuestDummyImpl();
        } else {
            System.err.println("Unknown guest implementation");
            System.exit(0);
        }
       
        while (playing) {
            GameCommand command = playerFacade.receiveGameCommand(president);
            if(command != null) {
                System.out.println("command name : "+ command.name()+" command body : "+command.body());
                switch (command.name()) {
                    case "cardsForYou":
                        handleCardsForYou(command);
                        break;
                    case "askForQueenOfHeart" :
                        handleAskForQueenOfHeart();
                        break;
                    case "play":
                        handlePlay(command);
                        break;
                    case "giveBestCards":
                        handleGiveBestCards(command);
                        break;
                    case "giveAndReceive" :
                        handleGiveCardsOfYourChoice(command);
                        break;
                    case "giveCardsForExchange" :
                        handleCardsReceivedForExchange(command);
                        break;
                    case "gameOver":
                        handleGameOverCommand(command);
                        break;
                    default :
                        break;
                }
            }
        }
    }

    /* method that checks which player has the queen of hearts so he can start the game */
    private static void handleAskForQueenOfHeart() {
        String result = "no";
        for (int i=0; i<hand.size()-1; i++){
            if (hand.get(i).getValue().equals(CardValue.QUEEN) && hand.get(i).getColor().equals(CardColor.HEART)){
                result = "yes";
            }
        }
        playerFacade.sendGameCommandToAll(president, new GameCommand("responseToQueenOfHeart", playerId+"="+result));
    }

    private static void handleCardsForYou(GameCommand command) {
        System.out.println(command.body());
        Card[] receiveCards = Card.stringToCards(command.body());
        List<Card> receiveCardsList = Arrays.asList(receiveCards);
        hand.clear();
        Collections.sort(receiveCardsList, new CardComparator());
        hand.addAll(receiveCardsList);
    }

    private static void handlePlay(GameCommand command) {
        // set the list of the n last moves extract from the command.body()
        updateLastNMoves(command.body());
        Card[] playedCards = guest.chooseCardsToPlay(hand,lastNMoves);
        System.out.println("playedCards : ");
        for ( Card card : playedCards){
            System.out.println(card);
        }
        // check playedCards.length <= hand.size() and playedCards exist in hand
        int nbOfCardsRemaining = hand.size() - playedCards.length;
        System.out.println("nb cards remaining : "+nbOfCardsRemaining);
        removeCardsFromHand(playedCards);
        if (playedCards.length == 0) {
            playerFacade.sendGameCommandToAll(president, new GameCommand("canNotPlay", "", Map.of("idPlayer",playerId,"nbcards",String.valueOf(nbOfCardsRemaining))));
        } else {
            String stringPlayedCards = Card.cardsToString(playedCards);
            playerFacade.sendGameCommandToAll(president, new GameCommand("played",stringPlayedCards, Map.of("idPlayer",playerId,"nbcards",String.valueOf(nbOfCardsRemaining))));
        }
    }

    private static void updateLastNMoves(String body) {
        List<Card[]> newLastMoves = new ArrayList<>();
        for (String move : body.split("#")){
            newLastMoves.add(Card.stringToCards(move));
        }
        lastNMoves = newLastMoves;
    }

    private static void removeCardsFromHand(Card[] cards){
        for (Card card : cards){
            hand.remove(card);
        }
    }

    protected static void handleGiveBestCards(GameCommand command) {
        int nbCards = Integer.parseInt(command.body());
        Card[] cards = guest.chooseBestCardsToGive(new ArrayList<>(hand), nbCards);
        removeCardsFromHand(cards);
        String playerToGive = command.params().get("toPlayer");
        GameCommand giveBestCards = new GameCommand("giveAndReceiveCards", Card.cardsToString(cards), Map.of("toPlayer", playerId));
        playerFacade.sendGameCommandToPlayer(president, playerToGive, giveBestCards);
    }

    protected static void handleGiveCardsOfYourChoice(GameCommand command) {
        Card[] cardsReceived = Card.stringToCards(command.body());
        Card[] cards = guest.chooseCardsOfYourChoiceToGive(new ArrayList<>(hand), cardsReceived.length);
        removeCardsFromHand(cards);
        hand.addAll(Arrays.asList(cardsReceived));
        Collections.sort(hand, new CardComparator());

        String playerToGive = command.params().get("toPlayer");
        GameCommand giveCardsOfYourChoice = new GameCommand("giveCardsForExchange", Card.cardsToString(cards), Map.of("toPlayer", playerId));
        playerFacade.sendGameCommandToPlayer(president, playerToGive, giveCardsOfYourChoice);
    }

    private static void handleCardsReceivedForExchange(GameCommand command) {
        Card[] cardsReceived = Card.stringToCards(command.body());
        hand.addAll(Arrays.asList(cardsReceived));
        Collections.sort(hand, new CardComparator());
        GameCommand exchangeOk = new GameCommand("exchangeOk");
        playerFacade.sendGameCommandToAll(president, exchangeOk);
    }


    private static void handleGameOverCommand(GameCommand command) {
        System.out.println("End of game, winner is xxx");
        playing = false;
    }
}