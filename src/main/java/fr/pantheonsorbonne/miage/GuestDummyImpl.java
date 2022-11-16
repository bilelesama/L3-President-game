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
    
}
