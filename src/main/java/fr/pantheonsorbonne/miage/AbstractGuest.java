package fr.pantheonsorbonne.miage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.pantheonsorbonne.miage.enums.CardValue;
import fr.pantheonsorbonne.miage.game.Card;

public class AbstractGuest {

    protected List<Card> playedCard = new ArrayList<>();

    // method that allows to play with a specified rank "play this rank card or pass " situation
    public Card playCardWithSpecificRank(Card card, List<Card> cardsPlayedBefore){
          if (card.getValue() == cardsPlayedBefore.get(0).getValue()) {
              playedCard.add(card);
          }
          return playedCard.get(playedCard.size()-1);
      }
  
      //method that puts the first card that can be played in a ArrayList(higher or with the same rank)
      public Card playTheFirstCard(Card card, List<Card> cardsPlayedBefore) {
          if (card.getValue() == CardValue.TWO){
              return card;
          }
          
          if (card.getValue().getRank() <= cardsPlayedBefore.get(0).getValue().getRank()) {
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

    public Map<CardValue, Integer> countFreq(List<Card> hand) {      
        Map<CardValue, Integer> mp = new HashMap<>();
        // Traverse through array elements and count frequencies
        for (Card card : hand) {
            mp.merge(card.getValue(), 1, Integer::sum);
        }
        return mp;
    }


    public int counterCardsFrequency(CardValue cardValue, List<Card> hand){
        return countFreq(hand).get(cardValue);
    }

    public boolean containsDual (Map<CardValue,Integer>map){
        return map.containsValue(2) || map.containsValue(4);
    }
    
    public boolean containsTriplet (Map<CardValue,Integer>map){
        return map.containsValue(3) || map.containsValue(4);
    }

    public int getNbCardsToPlay(List<Card[]> lastNMoves){
        int nb = 0;
        for (Card[] move : lastNMoves){
            nb = move.length;
        }
        return nb;
    }
}
