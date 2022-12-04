package fr.pantheonsorbonne.miage;

import java.util.List;

import fr.pantheonsorbonne.miage.game.Card;

public class GuestDummyImpl implements Guest {
    
    @Override
    public Card[] chooseCardsToPlay(List<Card> hand, List<Card[]> lastNMoves) {
        Card[] cardsToPlay = new Card[1];
        cardsToPlay[0] = hand.get(0); 
        return cardsToPlay;
    }

    @Override
    public Card[] chooseBestCardsToGive(List<Card> hand, int nbCards) {
        Card[] cards = new Card[nbCards];
        for (int i=0; i<nbCards; i++){
            cards[i] = hand.get(i);
        }
        return cards;
    }

    @Override
    public Card[] chooseCardsOfYourChoiceToGive(List<Card> hand, int nbCards) {
        Card[] cards = new Card[nbCards];
        for (int i=0; i<nbCards; i++){
            cards[i] = hand.get(hand.size()-1-i);
        }
        return cards;
    }
    
}
