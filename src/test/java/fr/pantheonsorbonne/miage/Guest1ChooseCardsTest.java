package fr.pantheonsorbonne.miage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.pantheonsorbonne.miage.enums.CardValue;
import fr.pantheonsorbonne.miage.game.Card;

class Guest1ChooseCardsTest {

    @Test
    public void chooseManyCardsWhenItIsDouble(){
        Guest1 guest = new Guest1();

        List<Card> cardsPlayedBefore = buildCardsListFromStr("5H;5S#3D;3S");
        String handStr = "10D;JS;1S;QH;KC;QC;5C;1C;9S;4S;1H;JH;JD";
        List<Card> hand = buildSortHand(handStr);
        List<Card> cards = guest.chooseManyCards(cardsPlayedBefore, hand, 2);

        Assertions.assertEquals(2, cards.size());
        List<CardValue> returnedValues = cards.stream().map(c -> c.getValue()).collect(Collectors.toList());
        List<CardValue> expectedValues = Arrays.asList(CardValue.ACE,CardValue.ACE);
        Assertions.assertIterableEquals(expectedValues, returnedValues);
    
    }

    @Test
    public void chooseManyCardsWhenItIsTriple(){
        Guest1 guest = new Guest1();

        List<Card> cardsPlayedBefore = buildCardsListFromStr("5H;5S;5D#3D;3S;3H");
        String handStr = "10D;QS;1S;QH;KC;QC;5C;1C;9S;4S;1H;JH;JD";
        List<Card> hand = buildSortHand(handStr);
        List<Card> cards = guest.chooseManyCards(cardsPlayedBefore, hand, 3);

        Assertions.assertEquals(3, cards.size());
        List<CardValue> returnedValues = cards.stream().map(c -> c.getValue()).collect(Collectors.toList());
        List<CardValue> expectedValues = Arrays.asList(CardValue.ACE,CardValue.ACE, CardValue.ACE);
        Assertions.assertIterableEquals(expectedValues, returnedValues);
    
    }

    @Test
    public void chooseManyCardsWhenNoDouble(){
        Guest1 guest = new Guest1();

        List<Card> cardsPlayedBefore = buildCardsListFromStr("5H;5S#3S;3H");
        String handStr = "10D;3D;6S;7H;KC;QC;5C;1C;9S;4S;4H;8H;JD";
        List<Card> hand = buildSortHand(handStr);
        List<Card> cards = guest.chooseManyCards(cardsPlayedBefore, hand, 2);

        Assertions.assertEquals(0, cards.size());
   
    }

    @Test
    public void chooseOneCard(){
        Guest1 guest = new Guest1();
        List<Card> cardsPlayedBefore = buildCardsListFromStr("4S");

        String handStr = "5D;8D;8C;3C;KS;6C;JD;5H;9D;1H;QD;7H;10H";
        List<Card> hand = buildSortHand(handStr);
        Card card = guest.chooseOneCard(cardsPlayedBefore, hand);
        Assertions.assertEquals(CardValue.ACE, card.getValue());


    }




    private List<Card> buildSortHand(String handStr){
        List<Card> hand = buildCardsListFromStr(handStr);
        Collections.sort(hand, new CardComparator());
        return hand;
    }

    private List<Card> buildCardsListFromStr(String cardsStr){
        return Arrays.asList(Card.stringToCards(cardsStr));
    }


}