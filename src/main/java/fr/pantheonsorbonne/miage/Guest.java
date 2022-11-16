package fr.pantheonsorbonne.miage;

import java.util.List;

import fr.pantheonsorbonne.miage.game.Card;

public interface Guest {
    Card[] chooseCardsToPlay(List<Card> hand, List<Card[]> lastNMoves);
    
}
