package fr.pantheonsorbonne.miage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import fr.pantheonsorbonne.miage.game.Card;
import fr.pantheonsorbonne.miage.game.PlayerResponse;

public class PresidentGameLocalPlayer {

    private final int id = new Random().nextInt();
    private String playerName;
    private String playerId;
    private List<Card> hand = new ArrayList<>();
    private List<Card[]> lastNMoves;
    private Guest guest;

    public PresidentGameLocalPlayer(String playerName, Guest guestImpl) {
        this.playerName = playerName;
        this.playerId = playerName+"#"+id;
        this.guest = guestImpl;
    }

    public void setHand(Card[] cardsToGive) {
        hand = new ArrayList<>(Arrays.asList(cardsToGive));
        Collections.sort(hand, new CardComparator());
    }

    public List<Card> getHand(){
        return this.hand;
    }

    public String getPlayerName() {
        return this.playerName;
    }


    public PlayerResponse playCards(List<Card[]> lastNMoves) {
        // set the list of the n last moves extract from the command.body()
        this.lastNMoves = lastNMoves;
        Card[] playedCards = guest.chooseCardsToPlay(hand,lastNMoves);
        System.out.println(playerName+" plays Cards : ");
        for ( Card card : playedCards){
            System.out.println(card);
        }
        // check playedCards.length <= hand.size() and playedCards exist in hand
        int nbOfCardsRemaining = hand.size() - playedCards.length;
        System.out.println("nb cards remaining : "+nbOfCardsRemaining);
        removeCardsFromHand(playedCards);
        return new PlayerResponse(playedCards, nbOfCardsRemaining);
    }
  
    private void removeCardsFromHand(Card[] cards){
        for (Card card : cards){
            hand.remove(card);
        }
    }

    public Card[] chooseBestCardsToGive(int nbCards) {
        Card[] cardsToGive = guest.chooseBestCardsToGive(hand, nbCards);
        removeCardsFromHand(cardsToGive);
        System.out.println(playerName+" gives : "+ Card.cardsToString(cardsToGive));
        return cardsToGive;
    }

    public Card[] chooseCardsOfYourChoiceToGive(int nbCards){
        Card[] cardsToGive = guest.chooseCardsOfYourChoiceToGive(hand, nbCards);
        removeCardsFromHand(cardsToGive);
        System.out.println(playerName+" gives : "+Card.cardsToString(cardsToGive));
        return cardsToGive;
    }

    public void addCardsToHand(Card[] CardsChoosed) {
        hand.addAll(Arrays.asList(CardsChoosed));
        Collections.sort(hand, new CardComparator());
    }


}    
