package fr.pantheonsorbonne.miage;

import java.util.ArrayList;
import java.util.List;

import fr.pantheonsorbonne.miage.game.Card;

public class AbstractGuest {

    protected List<Card> playedCard = new ArrayList<>();

    // method that allows to play with a specified rank "play this rank card or pass " situation
    public Card playCardWithSpecificRank(Card card, List<Card> cardsPlayedBefore){
        int  CARDS_PLAYED_BEFORE_SIZE = cardsPlayedBefore.size();
          if (card.getValue() == cardsPlayedBefore.get( CARDS_PLAYED_BEFORE_SIZE- 1).getValue()) {
              playedCard.add(card);
          }
          return playedCard.get(playedCard.size()-1);
      }
  
      //method that puts the first card that can be played in a ArrayList(higher or with the same rank)
      public Card playTheFirstCard(Card card, List<Card> cardsPlayedBefore) {
          int CARDS_PLAYED_BEFORE_SIZE = cardsPlayedBefore.size();
          if ( card.getValue().getRank() ==2){
              return card;
          }
          else if (card.getValue().getRank() == cardsPlayedBefore.get(CARDS_PLAYED_BEFORE_SIZE - 1).getValue().getRank()) {
              return card;
          }
          else if (card.getValue().getRank() > cardsPlayedBefore.get(CARDS_PLAYED_BEFORE_SIZE - 1).getValue().getRank()) {
              return card;
          }
          return null;
      }
    
    // method that allows to update the ArrayList of cards played before
    public static List<Card> updatingCardsPlayedBefore(List<Card> playedCard, List<Card> cardsPlayedBefore){
        cardsPlayedBefore.addAll(playedCard);
        return cardsPlayedBefore;
    }

    //method that gives the number of cards left for each player
    public static int getNumberOfCardsLeft(List<Card> hand){
        return hand.size();
    }

    public static Card[] getCardsToPlayToArray(List<Card> playedCard){
        Card[] returnCard = new Card[playedCard.size()];
        for(int i=0; i<playedCard.size(); i++) {
            returnCard[i] = playedCard.get(i);
        }
        return returnCard;
    }
}
