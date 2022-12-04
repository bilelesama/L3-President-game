package fr.pantheonsorbonne.miage;
import fr.pantheonsorbonne.miage.enums.CardValue;
import fr.pantheonsorbonne.miage.game.Card;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Guest2 extends AbstractGuest implements Guest{
    static Card cardToPlay = null;

    @Override
    public Card[] chooseCardsToPlay(List<Card>hand, List<Card[]> lastNMoves){
        Map<CardValue,Integer> frequency = countFreq(hand);
        List<Card> cardsPlayedBefore = new ArrayList<>();
        
        int nbCardsToPlay = getNbCardsToPlay(lastNMoves);

        if (nbCardsToPlay == 1) {
             playedCard.add(chooseOneCard(cardsPlayedBefore, hand));
        }
        else {
            if (nbCardsToPlay != 0) {
                 playedCard = chooseManyCards(cardsPlayedBefore, hand, nbCardsToPlay);
            }
            else {
                playedCard = chooseFirstCardsToPlay(hand);
            }
        }

        for(Card card : playedCard){
            hand.remove(card);
        }
        return getCardsToPlayToArray(playedCard);
    }

    private List<Card> chooseFirstCardsToPlay(List<Card> hand) {
        Card firstCard = hand.get(hand.size()-1);
        List<Card> cards = new ArrayList<>();
        int count = counterCardsFrequency(firstCard.getValue(), hand);
        switch (count){
            case 1:
                cards.add(firstCard);
                break;
            case 2:
                cards.add(firstCard);
                cards.add(hand.get(hand.size()-2));
                break;
            case 3:
                cards.add(firstCard);
                cards.add(hand.get(hand.size()-2));
                cards.add(hand.get(hand.size()-3));
                break;
        }
        return cards;
    }

    public Card chooseOneCard(List<Card> cardsPlayedBefore, List<Card> hand) {
        if (checkingLastTwoCards(hand)) {
            for (Card card : hand) {
                if (card.getValue() == CardValue.TWO) {
                    cardToPlay = card;
                }
            }
        } else {
            //plays the lowest cards
            for (int i = hand.size()-1; i >= 0; i--) {
                if (playTheFirstCard(hand.get(i), cardsPlayedBefore) != null) {
                    cardToPlay=hand.get(i);
                    break;
                }
            }
        }
        return cardToPlay;
    }

    public List<Card> chooseManyCards(List<Card> cardsPlayedBefore, List<Card> hand, int nbCardsToPlay) {
        List<Card> playCards = new ArrayList<>();
        Map<CardValue,Integer> frequencyMap = countFreq(hand);
        Card cardToPlay;
        //if there's no dual or triplet in the hand
        if (!frequencyMap.containsValue(nbCardsToPlay)){
            return playCards;
        }
        // if there's a specific number of cards to play
        if (nbCardsToPlay != 0) {
           playedCard=playingManyCardsAccordingToLastPlayed(hand,cardsPlayedBefore,nbCardsToPlay,playCards);
        }
        //if there's no specific number of cards to play
        else {
                cardToPlay = chooseManyCardsWithoutSpecificNumber(frequencyMap);
                for (int i=0;i< frequencyMap.get(cardToPlay); i++){
                playCards.add(cardToPlay);
        }}
        return playCards;
    }

    public static boolean checkingLastTwoCards(List<Card> hand) {
        if (hand.size() == 2) {
            for (Card card : hand) {
                if (card.getValue() == CardValue.TWO) {
                    return true; 
                }
            }
        }
        return false;
    }

    public Card choosingATriplet(Map<CardValue,Integer>map) {
        for (Map.Entry m : map.entrySet()) {
            if (m.getValue().equals(3)) {
                cardToPlay = (Card) m.getKey();
            }
            break;
        }
        return cardToPlay;
    }

    public Card choosingADual(Map<CardValue,Integer>map) {
        Card cardToPlay=null;
        for (Map.Entry m : map.entrySet()) {
            if (m.getValue().equals(2)) {
                cardToPlay = (Card) m.getKey();
            }
            break;
        }
        return cardToPlay;
    }

    public Card chooseManyCardsWithoutSpecificNumber(Map<CardValue,Integer>frequencyMap){
        //playing the triplet if there's one
        if (containsTriplet(frequencyMap)) {
        cardToPlay = choosingATriplet(frequencyMap);
    }
    //if not play the dual
        else{
        if(containsDual(frequencyMap)) {
            cardToPlay = choosingADual(frequencyMap);
        }
    }
    return cardToPlay;
    }

    public List<Card> playingManyCardsAccordingToLastPlayed(List<Card>hand,List<Card>cardsPlayedBefore, int nbCardsToPlay, List<Card>playCards ) {
        int lastCardRank=cardsPlayedBefore.get(0).getValue().getRank();
        for (int i = hand.size()-1; i >=0; i--) {
            int currentCardRank=hand.get(i).getValue().getRank();
            // checking if the current card is higher or equal to the last added card
            if(currentCardRank <= lastCardRank){
                if( playedCard.isEmpty()){
                    playedCard.add(hand.get(i));
                }
                // if playedCard isn't empty and contains the same rank card than currentCardRank
                // if playedCard does not have a size equal to nbCarsToPlay
                else if (( playedCard.get(0).getValue().getRank() ==currentCardRank ) && ( playedCard.size()<nbCardsToPlay )){
                    //adding the card to playedCard
                    playedCard.add(hand.get(i));
                    //updating lastCardRank
                    lastCardRank=currentCardRank;
                    //if playedCard has the expected size
                    if ( playedCard.size()==nbCardsToPlay ){
                        return playedCard;
                    }
                }
                else{
                    playedCard.clear();
                    playedCard.add(hand.get(i));
                }
            }
        }
        playedCard.clear();
        return playedCard;
    }

    @Override
    public Card[] chooseBestCardsToGive(List<Card> hand, int nbCards) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Card[] chooseCardsOfYourChoiceToGive(List<Card> hand, int nbCards) {
        // TODO Auto-generated method stub
        return null;
    }

}
