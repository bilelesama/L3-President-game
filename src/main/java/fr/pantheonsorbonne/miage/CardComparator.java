package fr.pantheonsorbonne.miage;

import java.util.Comparator;

import fr.pantheonsorbonne.miage.game.Card;

public class CardComparator implements Comparator<Card> {

    @Override
    public int compare(Card arg0, Card arg1) {
        return arg0.getValue().getRank() - arg1.getValue().getRank();
    }

}
