package fr.pantheonsorbonne.miage.game;

import java.util.Arrays;
import java.util.stream.Collectors;
import fr.pantheonsorbonne.miage.enums.CardColor;
import fr.pantheonsorbonne.miage.enums.CardValue;

public class Card {
    private final CardColor color;
    private final CardValue value;

    public Card(CardColor color, CardValue value) {
        this.value = value;
        this.color = color;
    }

    public CardValue getValue() {
        return value;
    }

    public CardColor getColor() {
        return color;
    }

    public static Card valueOf(String str) {
        CardValue value;
        CardColor color;
        if (str.length() == 3) {// it's a 10
            value = CardValue.valueOfStr(str.substring(0, 2));
            color = CardColor.valueOfStr(str.substring(2, 3));
        } else {
            value = CardValue.valueOfStr(str.substring(0, 1));
            color = CardColor.valueOfStr(str.substring(1, 2));
        }
        return new Card(color, value);
    }

    /*
     * this method allows to switch from real cards to a flattened version (String
     * version )
     */
    public static String cardsToString(Card[] cards) {
        return Arrays.stream(cards).map(Card::toString).collect(Collectors.joining(";"));
    }

    /*
     * this method does the opposite of what the previous does ( from String to real
     * cards )
     */
    public static Card[] stringToCards(String cards) {
        /* checking if the string is empty, if that's the case create a new card */
        if (cards.isEmpty()) {
            return new Card[0];
        }
        /* else, setting cards according to the String data */
        return (Card[]) Arrays.stream(cards.split(";")).map(Card::valueOf).toArray(Card[]::new);
    }

    /* this method is overrided from toString of the object class */
    @Override
    public String toString() {
        return this.value.getStringRepresentation() + this.color.getStringRepresentation();
    }
}