package fr.pantheonsorbonne.miage;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.pantheonsorbonne.miage.enums.CardColor;
import fr.pantheonsorbonne.miage.enums.CardValue;
import fr.pantheonsorbonne.miage.game.Card;

public class AbstractGuestTest {

    @Test
    public void getNbCardsToPlay_shouldReturn1WhenOneCardPlayed(){
        Guest2 guest = new Guest2();
        //"9D#7S"
        Card[] previousMove = new Card[]{new Card(CardColor.DIAMOND, CardValue.NINE)};
        Card[] previousMove2 = new Card[]{new Card(CardColor.SPADE, CardValue.SEVEN)};
        List<Card[]> lastNMoves = Arrays.asList(previousMove, previousMove2);

        int nb = guest.getNbCardsToPlay(lastNMoves);

        Assertions.assertEquals(1, nb);

    }

    @Test
    public void getNbCardsToPlay_shouldReturn2WhenTwoCardsPlayed(){
        Guest2 guest = new Guest2();
        //"9D,9H#7S,7D"
        Card[] previousMove = new Card[]{new Card(CardColor.DIAMOND, CardValue.NINE), new Card(CardColor.HEART, CardValue.NINE)};
        Card[] previousMove2 = new Card[]{new Card(CardColor.SPADE, CardValue.SEVEN), new Card(CardColor.DIAMOND, CardValue.SEVEN)};
        List<Card[]> lastNMoves = Arrays.asList(previousMove, previousMove2);

        int nb = guest.getNbCardsToPlay(lastNMoves);

        Assertions.assertEquals(2, nb);

    }

    @Test
    public void getNbCardsToPlay_shouldReturn1WhenNoCardPlayedBeforeButOneWasBefore(){
        Guest2 guest = new Guest2();
        //"##7S"
        Card[] previousMove = new Card[0];
        Card[] previousMove2 = new Card[0];
        Card[] previousMove3 = new Card[]{new Card(CardColor.SPADE, CardValue.SEVEN)};
        List<Card[]> lastNMoves = Arrays.asList(previousMove, previousMove2, previousMove3);

        int nb = guest.getNbCardsToPlay(lastNMoves);

        Assertions.assertEquals(1, nb);

    }

    @Test
    public void getNbCardsToPlay_shouldReturnDefaultValueWhenFirstPlayer(){
        Guest2 guest = new Guest2();
        int nb = guest.getNbCardsToPlay(Collections.emptyList());

        Assertions.assertEquals(0, nb);
    }

    
}