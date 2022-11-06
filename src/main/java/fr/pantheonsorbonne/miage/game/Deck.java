package fr.pantheonsorbonne.miage.game;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import fr.pantheonsorbonne.miage.enums.CardColor;
import fr.pantheonsorbonne.miage.enums.CardValue;

/**
 * Represents a Deck of cards
 */
public class Deck {

    private final  Random random = new Random();
    private int deckSize = CardValue.values().length * CardColor.values().length;
    private final List<Card> cardsGame;

    /* disallow instantiation */
    public Deck() {
        Card[] deck = new Card[deckSize];
        int cardCount = deckSize;
        //generate all cards
        for (CardColor color : CardColor.values()) {
            for (CardValue value : CardValue.values()) {
                deck[cardCount-- - 1] = new Card(color, value);
            }
        }
        //shuffle them
        for (int i = 0; i < deckSize; i++) {
            int randomIndexToSwap = random.nextInt(deckSize);
            Card temp = deck[randomIndexToSwap];
            deck[randomIndexToSwap] = deck[i];
            deck[i] = temp;
        }

        this.cardsGame = new ArrayList<>();
        cardsGame.addAll(Arrays.asList(deck));
    }

    public Card[] giveCards(int nbCards) {
        Card[] cards = new Card[nbCards];
        for (int i=0; i<nbCards; i++) {
            cards[i]=cardsGame.remove(0);
        }
        return cards;
    }

    public int getDeckSize() {
        return deckSize;
    }
}
