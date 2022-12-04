package fr.pantheonsorbonne.miage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.pantheonsorbonne.miage.game.Card;

public class Guest1 extends AbstractGuest implements Guest {

    @Override
    public Card[] chooseCardsToPlay(List<Card> hand, List<Card[]> lastNMoves) {
        int nbCardsToPlay = 1;
        List<Card> cardsPlayedBefore = new ArrayList<>();
        if (!lastNMoves.isEmpty() && lastNMoves.get(0).length != 0){
            nbCardsToPlay = lastNMoves.get(0).length;
            cardsPlayedBefore = new ArrayList<>(Arrays.asList(lastNMoves.get(0)));
        }

        if (nbCardsToPlay == 1) {
            playedCard.add(chooseOneCard(cardsPlayedBefore, hand));
        }
        else {
            playedCard = chooseManyCards(cardsPlayedBefore, hand, nbCardsToPlay);
        }
        return getCardsToPlayToArray(playedCard);
    }



    @Override
    public Card[] chooseBestCardsToGive(List<Card> hand, int nbCards) {
        List<Card> bestCards = new ArrayList<>();
        for (int i=0; i<nbCards; i++){
            bestCards.add(hand.get(0));
            hand.remove(0);
        }
        return getCardsToPlayToArray(bestCards);
    }

    @Override
    public Card[] chooseCardsOfYourChoiceToGive(List<Card> hand, int nbCards) {
        List<Card> cardsOfYourChoice = new ArrayList<>();
        for (int i=0; i<nbCards; i++){
            cardsOfYourChoice.add(hand.get(hand.size()-1));
            hand.remove(hand.size()-1);
        }
        return getCardsToPlayToArray(cardsOfYourChoice);
    }

    // Guest 1 strategy :choosing the first card that can be played
    public Card chooseOneCard(List<Card> cardsPlayedBefore, List<Card> hand) {
        int CARDS_PLAYED_BEFORE_SIZE = cardsPlayedBefore.size();
        List<Card> playedCard = new ArrayList<>();
        if(cardsPlayedBefore.isEmpty()){
            return hand.get(hand.size()-1);
        }
        for (Card card : hand) {
            if (CARDS_PLAYED_BEFORE_SIZE >= 2) {
                //if the two last cards have the same rank, the next player has to play a same rank card
                if ((cardsPlayedBefore.get(CARDS_PLAYED_BEFORE_SIZE - 1).getValue()).compareTo(cardsPlayedBefore.get(CARDS_PLAYED_BEFORE_SIZE - 2).getValue()) == 0) {
                    playedCard.add(playCardWithSpecificRank(card, cardsPlayedBefore));
                } else if (cardsPlayedBefore.get(CARDS_PLAYED_BEFORE_SIZE - 1).getValue().compareTo(cardsPlayedBefore.get(CARDS_PLAYED_BEFORE_SIZE - 2).getValue()) > 0) {
                    // if there's not just play a random card
                    playedCard.add(playTheFirstCard(card, cardsPlayedBefore));
                }
            } else {
                playedCard.add(playTheFirstCard(card, cardsPlayedBefore));
            }
        }
        return playedCard.get(0);

    }

    //override method according to Guest 1 strategy
    // choosing the first cards that can be played
    public List<Card> chooseManyCards(List<Card> cardsPlayedBefore, List<Card> hand, int nbCardsToPlay) {
        List<Card> playCards = new ArrayList<>();
            for (Card card : hand ) {
                    if (playTheFirstCard(card, cardsPlayedBefore) != null) {
                        if (playedCard.isEmpty()) {
                            playedCard.add(card);

                        } else {
                            //checking if the card matches the rank of the last added card in playedCard
                            if (playedCard.get(playedCard.size() - 1).getValue() == card.getValue()) {
                                playedCard.add(card);
                            }

                            // if not, clearing playedCard and adding the new card
                            else {
                                playedCard.clear();
                                playedCard.add(card);
                            }
                        }
                    }
                }
            if (nbCardsToPlay==0){
                return playedCard;
            }
            for(int i=0; i<nbCardsToPlay; i++){
                playCards.add(playedCard.get(i));
            }
        return playCards;


    }
    
}
