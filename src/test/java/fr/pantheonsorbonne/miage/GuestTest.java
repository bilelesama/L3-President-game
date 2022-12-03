package fr.pantheonsorbonne.miage;

import fr.pantheonsorbonne.miage.enums.CardColor;
import fr.pantheonsorbonne.miage.enums.CardValue;
import fr.pantheonsorbonne.miage.game.Card;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


class GuestTest {
    static ArrayList<Card> cardsPlayedBefore = new ArrayList<>();
    static ArrayList<Card> playedCard = new ArrayList<>();
    static ArrayList<Card> hand = new ArrayList<>();


    // colors
    static CardColor colorS = CardColor.valueOfStr("S");
    static CardColor colorC = CardColor.valueOfStr("C");
    static CardColor colorD = CardColor.valueOfStr("D");
    static CardColor colorH = CardColor.valueOfStr("H");

    // values
    static CardValue value3 = CardValue.valueOfStr("3");
    static CardValue value4 = CardValue.valueOfStr("4");
    static CardValue value5 = CardValue.valueOfStr("5");
    static CardValue value6 = CardValue.valueOfStr("6");
    static CardValue value7 = CardValue.valueOfStr("7");
    static CardValue value8 = CardValue.valueOfStr("8");
    static CardValue value9 = CardValue.valueOfStr("9");
    static CardValue value10 = CardValue.valueOfStr("10");
    static CardValue valueJ = CardValue.valueOfStr("J");
    static CardValue valueQ = CardValue.valueOfStr("Q");
    static CardValue valueK = CardValue.valueOfStr("K");
    static CardValue valueAce = CardValue.ACE;
    static CardValue value2 = CardValue.valueOfStr("2");

    // card 3 club //
    static Card card3C = new Card(colorC, value3);
    // card 3 diamond //
    static Card card3D = new Card(colorD, value3);
    // card 3 heart //
    static Card card3H = new Card(colorH, value3);
    //card 3 spade
    static Card card3S = new Card(colorS, value3);

    //card 4 club //
    static Card card4C = new Card(colorC, value4);
    //card 4 diamond //
    static Card card4D = new Card(colorD, value4);
    // card 4 heart //
    static Card card4H = new Card(colorH, value4);
    //card 4 spade //
    static Card card4S = new Card(colorS, value4);

    //card 5 club //
    static Card card5C = new Card(colorC, value5);
    //card 5 diamond //
    static Card card5D = new Card(colorD, value5);
    //card 5 heart //
    static Card card5H = new Card(colorH, value5);
    //card 5 spade //
    static Card card5S = new Card(colorS, value5);

    //card 6 club //
    static Card card6C = new Card(colorC, value6);
    //card 6 diamond //
    static Card card6D = new Card(colorD, value6);
    //card 6 heart //
    static Card card6H = new Card(colorH, value6);
    //card 6 spade //
    static Card card6S = new Card(colorS, value6);

    //card 7 club //
    static Card card7C = new Card(colorC, value7);
    //card 7 diamond //
    static Card card7D = new Card(colorD, value7);
    //card 7 heart //
    static Card card7H = new Card(colorH, value7);
    //card 7 spade //
    static Card card7S = new Card(colorS, value7);

    //card 8 club //
    static Card card8C = new Card(colorC, value8);
    //card 8 diamond //
    static Card card8D = new Card(colorD, value8);
    //card 8 heart //
    static Card card8H = new Card(colorH, value8);
    //card 8 spade //
    static Card card8S = new Card(colorS, value8);

    //card 9  club //
    static Card card9C = new Card(colorC, value9);
    //card 9 diamond //
    static Card card9D = new Card(colorD, value9);
    //card 9 heart //
    static Card card9H = new Card(colorH, value9);
    //card 9 spade //
    static Card card9S = new Card(colorS, value9);


    //card 10  club //
    static Card card10C = new Card(colorC, value10);
    //card 10 diamond //
    static Card card10D = new Card(colorD, value10);
    //card 10 heart //
    static Card card10H = new Card(colorH, value10);
    //card 10 spade //
    static Card card10S = new Card(colorS, value10);


    //card J  club //
    static Card cardJC = new Card(colorC, valueJ);
    //card J diamond //
    static Card cardJD = new Card(colorD, valueJ);
    //card J heart //
    static Card cardJH = new Card(colorH, valueJ);
    //card J spade //
    static Card cardJS = new Card(colorS, valueJ);

    //card Q  club //
    static Card cardQC = new Card(colorC, valueQ);
    //card Q diamond //
    static Card cardQD = new Card(colorD, valueQ);
    //card Q heart //
    static Card cardQH = new Card(colorH, valueQ);
    //card Q spade //
    static Card cardQS = new Card(colorS, valueQ);

    //card K club //
    static Card cardKC = new Card(colorC, valueK);
    //card K diamond //
    static Card cardKD = new Card(colorD, valueK);
    //card K heart //
    static Card cardKH = new Card(colorH, valueK);
    //card K spade //
    static Card cardKS = new Card(colorS, valueK);

    //card Ace club //
    static Card cardAC = new Card(colorC, valueAce);
    //card Ace diamond //
    static Card cardAD = new Card(colorD, valueAce);
    //card Ace heart //
    static Card cardAH = new Card(colorH, valueAce);
    //card Ace spade //
    static Card cardAS = new Card(colorS, valueAce);

    //card 2 club //
    static Card card2C = new Card(colorC, value2);
    //card 2 diamond //
    static Card card2D = new Card(colorD, value2);
    //card 2 heart //
    static Card card2H = new Card(colorH, value2);
    //card 2 spade //
    static Card card2S = new Card(colorS, value2);

    @Test
    public void updatingCardsPlayedBefore3H() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card3H);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBefore3C() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card3C);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBefore3S() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card3S);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBefore3D() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card3D);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBefore4C() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card4C);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBefore4H() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card4H);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBefore4S() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card4S);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBefore4D() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card4D);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBefore5H() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card5H);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBefore5C() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card5C);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBefore5S() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card5S);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBefore5D() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card5D);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBefore6H() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card6H);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBefore6C() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card6C);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBefore6S() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card6S);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBefore6D() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card6D);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBefore7H() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card7H);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBefore7C() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card7C);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBefore7S() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card7S);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBefore7D() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card7D);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBefore8H() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card8H);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBefore8C() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card8C);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBefore8S() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card8S);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBefore8D() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card8D);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBefore9H() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card9H);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBefore9C() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card9C);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBefore9S() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card9S);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBefore9D() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card9D);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBefore10H() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card10H);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBefore10C() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card10C);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBefore10S() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card10S);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBefore10D() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card10D);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeJH() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(cardJH);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeJC() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(cardJC);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeJS() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(cardJS);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeJD() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(cardJD);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeQH() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(cardQH);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeQC() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(cardQC);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeQS() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(cardQS);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeQD() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(cardQD);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeKH() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(cardKH);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeKC() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(cardKC);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeKS() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(cardKS);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeKD() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(cardKD);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWith2cardsSameRankQ() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(cardQD);
        playedCard.add(cardQS);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWith3cardsSameRankQ() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(cardQD);
        playedCard.add(cardQS);
        playedCard.add(cardQH);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWith4cardsSameRankQ() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(cardQD);
        playedCard.add(cardQS);
        playedCard.add(cardQH);
        playedCard.add(cardQC);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWith2cardsSameRankJ() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(cardJD);
        playedCard.add(cardJS);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWith3cardsSameRankJ() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(cardJD);
        playedCard.add(cardJS);
        playedCard.add(cardJH);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWith4cardsSameRankJ() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(cardJD);
        playedCard.add(cardJS);
        playedCard.add(cardJH);
        playedCard.add(cardJC);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWith2cardsSameRank10() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card10D);
        playedCard.add(card10S);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWith3cardsSameRank10() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card10D);
        playedCard.add(card10S);
        playedCard.add(card10H);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWith4cardsSameRank10() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card10D);
        playedCard.add(card10S);
        playedCard.add(card10H);
        playedCard.add(card10C);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWith2cardsSameRank9() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card9D);
        playedCard.add(card9S);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWith3cardsSameRank9() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card9D);
        playedCard.add(card9S);
        playedCard.add(card9H);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWith4cardsSameRank9() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card9D);
        playedCard.add(card9S);
        playedCard.add(card9H);
        playedCard.add(card9C);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWith2cardsSameRank8() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card8D);
        playedCard.add(card8S);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWith3cardsSameRank8() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card8D);
        playedCard.add(card8S);
        playedCard.add(card8H);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWith4cardsSameRank8() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card8D);
        playedCard.add(card8S);
        playedCard.add(card8H);
        playedCard.add(card8C);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWith2cardsSameRank7() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card7D);
        playedCard.add(card7S);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWith3cardsSameRank7() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card7D);
        playedCard.add(card7S);
        playedCard.add(card7H);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWith4cardsSameRank7() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card7D);
        playedCard.add(card7S);
        playedCard.add(card7H);
        playedCard.add(card7H);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWith2cardsSameRank6() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card6D);
        playedCard.add(card6S);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWith3cardsSameRank6() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card6D);
        playedCard.add(card6S);
        playedCard.add(card6H);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWith4cardsSameRank6() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card6D);
        playedCard.add(card6S);
        playedCard.add(card6H);
        playedCard.add(card6C);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWith2cardsSameRank5() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card5D);
        playedCard.add(card5S);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWith3cardsSameRank5() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card5D);
        playedCard.add(card5S);
        playedCard.add(card5H);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWith4cardsSameRank5() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card5D);
        playedCard.add(card5S);
        playedCard.add(card5H);
        playedCard.add(card5C);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWith2cardsSameRank4() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card4D);
        playedCard.add(card4S);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWith3cardsSameRank4() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card4D);
        playedCard.add(card4S);
        playedCard.add(card4H);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWith4cardsSameRank4() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card4D);
        playedCard.add(card4S);
        playedCard.add(card4H);
        playedCard.add(card4C);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWith2cardsSameRank3() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card3D);
        playedCard.add(card3S);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWith3cardsSameRank3() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card3D);
        playedCard.add(card3S);
        playedCard.add(card3H);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWith4cardsSameRank3() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card3D);
        playedCard.add(card3S);
        playedCard.add(card3H);
        playedCard.add(card3C);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWith2cardsSameRank2() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card2S);
        playedCard.add(card2S);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWithAdd3cardsSameRank2() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card2S);
        playedCard.add(card2S);
        playedCard.add(card2H);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWith4cardsSameRank2() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(card2S);
        playedCard.add(card2S);
        playedCard.add(card2H);
        playedCard.add(card2C);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWith2cardsSameRankK() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(cardKD);
        playedCard.add(cardKS);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWith3cardsSameRankK() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(cardKD);
        playedCard.add(cardKS);
        playedCard.add(cardKH);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWith4cardsSameRankK() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(cardKD);
        playedCard.add(cardKS);
        playedCard.add(cardKH);
        playedCard.add(cardKC);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWith2cardsSameRankAce() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(cardAD);
        playedCard.add(cardAS);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWith3cardsSameRankAce() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(cardAD);
        playedCard.add(cardAS);
        playedCard.add(cardAH);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void updatingCardsPlayedBeforeWith4cardsSameRankAce() {
        AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore).clear();
        playedCard.add(cardAD);
        playedCard.add(cardAS);
        playedCard.add(cardAH);
        playedCard.add(cardAC);
        assertEquals(playedCard, AbstractGuest.updatingCardsPlayedBefore(playedCard, cardsPlayedBefore));
    }

    @Test
    public void getNumberOfCardsLeftOfEmptyHand() {
        assertEquals(0, AbstractGuest.getNumberOfCardsLeft(hand));
    }

    @Test
    public void getNumberOfCardsLeftOfHandSize1() {
        hand.add(cardKD);
        assertEquals(1, AbstractGuest.getNumberOfCardsLeft(hand));
        hand.clear();
    }

    @Test
    public void getNumberOfCardsLeftOfHandSize2() {
        hand.add(cardKD);
        hand.add(cardKS);
        assertEquals(2, AbstractGuest.getNumberOfCardsLeft(hand));
        hand.clear();
    }

    @Test
    public void getNumberOfCardsLeftOfHandSize3() {
        hand.add(cardKD);
        hand.add(cardKS);
        hand.add(cardKC);
        assertEquals(3, AbstractGuest.getNumberOfCardsLeft(hand));
        hand.clear();
    }

    @Test
    public void getNumberOfCardsLeftOfHandSize4() {
        hand.add(cardKD);
        hand.add(cardKS);
        hand.add(cardKC);
        hand.add(cardKH);
        assertEquals(4, AbstractGuest.getNumberOfCardsLeft(hand));
        hand.clear();
    }

    @Test
    public void getNumberOfCardsLeftOfHandSize5() {
        hand.add(cardKD);
        hand.add(cardKS);
        hand.add(cardKC);
        hand.add(cardKH);
        hand.add(cardQD);
        assertEquals(5, AbstractGuest.getNumberOfCardsLeft(hand));
        hand.clear();
    }

    @Test
    public void getNumberOfCardsLeftOfHandSize6() {
        hand.add(cardKD);
        hand.add(cardKS);
        hand.add(cardKC);
        hand.add(cardKH);
        hand.add(cardQD);
        hand.add(cardQS);
        assertEquals(6, AbstractGuest.getNumberOfCardsLeft(hand));
        hand.clear();
    }

    @Test
    public void getNumberOfCardsLeftOfHandSize7() {
        hand.add(cardKD);
        hand.add(cardKS);
        hand.add(cardKC);
        hand.add(cardKH);
        hand.add(cardQD);
        hand.add(cardQS);
        hand.add(cardQH);
        assertEquals(7, AbstractGuest.getNumberOfCardsLeft(hand));
        hand.clear();
    }

    @Test
    public void getNumberOfCardsLeftOfHandSize8() {
        hand.add(cardKD);
        hand.add(cardKS);
        hand.add(cardKC);
        hand.add(cardKH);
        hand.add(cardQD);
        hand.add(cardQS);
        hand.add(cardQH);
        hand.add(cardQC);
        assertEquals(8, AbstractGuest.getNumberOfCardsLeft(hand));
        hand.clear();
    }

    @Test
    public void getNumberOfCardsLeftOfHandSize9() {
        hand.add(cardKD);
        hand.add(cardKS);
        hand.add(cardKC);
        hand.add(cardKH);
        hand.add(cardQD);
        hand.add(cardQS);
        hand.add(cardQH);
        hand.add(cardQC);
        hand.add(cardJD);
        assertEquals(9, AbstractGuest.getNumberOfCardsLeft(hand));
        hand.clear();

    }

    @Test
    public void getNumberOfCardsLeftOfHandSize10() {
        hand.add(cardKD);
        hand.add(cardKS);
        hand.add(cardKC);
        hand.add(cardKH);
        hand.add(cardQD);
        hand.add(cardQS);
        hand.add(cardQH);
        hand.add(cardQC);
        hand.add(cardJD);
        hand.add(cardJS);
        assertEquals(10, AbstractGuest.getNumberOfCardsLeft(hand));
        hand.clear();
    }

    @Test
    public void getNumberOfCardsLeftOfHandSize11() {
        hand.add(cardKD);
        hand.add(cardKS);
        hand.add(cardKC);
        hand.add(cardKH);
        hand.add(cardQD);
        hand.add(cardQS);
        hand.add(cardQH);
        hand.add(cardQC);
        hand.add(cardJD);
        hand.add(cardJS);
        hand.add(cardJH);
        assertEquals(11, AbstractGuest.getNumberOfCardsLeft(hand));
        hand.clear();
    }

    @Test
    public void getNumberOfCardsLeftOfHandSize12() {
        hand.add(cardKD);
        hand.add(cardKS);
        hand.add(cardKC);
        hand.add(cardKH);
        hand.add(cardQD);
        hand.add(cardQS);
        hand.add(cardQH);
        hand.add(cardQC);
        hand.add(cardJD);
        hand.add(cardJS);
        hand.add(cardJH);
        hand.add(cardJC);
        assertEquals(12, AbstractGuest.getNumberOfCardsLeft(hand));
        hand.clear();
    }

    @Test
    public void getNumberOfCardsLeftOfHandSize13() {
        hand.add(cardKD);
        hand.add(cardKS);
        hand.add(cardKC);
        hand.add(cardKH);
        hand.add(cardQD);
        hand.add(cardQS);
        hand.add(cardQH);
        hand.add(cardQC);
        hand.add(cardJD);
        hand.add(cardJS);
        hand.add(cardJH);
        hand.add(cardJC);
        hand.add(card9D);
        assertEquals(13, AbstractGuest.getNumberOfCardsLeft(hand));
        hand.clear();
    }

    // @Test
    // public void playCardWithSpecificRank() {
    //     cardsPlayedBefore.add(card6H);
    //     assertEquals(card6H, AbstractGuest.playCardWithSpecificRank(card6H, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardWitSameColorSameRank2() {
    //     cardsPlayedBefore.add(card2H);
    //     assertEquals(card2H, AbstractGuest.playCardWithSpecificRank(card2H, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardWitSameColorSameRank3() {
    //     cardsPlayedBefore.add(card3H);
    //     assertEquals(card3H, AbstractGuest.playCardWithSpecificRank(card3H, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardWitSameColorSameRank4() {
    //     cardsPlayedBefore.add(card4H);
    //     assertEquals(card4H, AbstractGuest.playCardWithSpecificRank(card4H, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardWitSameColorSameRank5() {
    //     cardsPlayedBefore.add(card5H);
    //     assertEquals(card5H, AbstractGuest.playCardWithSpecificRank(card5H, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardWitSameColorSameRank6() {
    //     cardsPlayedBefore.add(card6H);
    //     assertEquals(card6H, AbstractGuest.playCardWithSpecificRank(card6H, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardWitSameColorSameRank7() {
    //     cardsPlayedBefore.add(card7H);
    //     assertEquals(card7H, AbstractGuest.playCardWithSpecificRank(card7H, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardWitSameColorSameRank8() {
    //     cardsPlayedBefore.add(card8H);
    //     assertEquals(card8H, AbstractGuest.playCardWithSpecificRank(card8H, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardWitSameColorSameRank9() {
    //     cardsPlayedBefore.add(card9H);
    //     assertEquals(card9H, AbstractGuest.playCardWithSpecificRank(card9H, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardWitSameColorSameRank10() {
    //     cardsPlayedBefore.add(card10H);
    //     assertEquals(card10H, AbstractGuest.playCardWithSpecificRank(card10H, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardWitSameColorSameRankJ() {
    //     cardsPlayedBefore.add(cardJH);
    //     assertEquals(cardJH, AbstractGuest.playCardWithSpecificRank(cardJH, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardWitSameColorSameRankQ() {
    //     cardsPlayedBefore.add(cardQH);
    //     assertEquals(cardQH, AbstractGuest.playCardWithSpecificRank(cardQH, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardWitSameColorSameRankK() {
    //     cardsPlayedBefore.add(cardKH);
    //     assertEquals(cardKH, AbstractGuest.playCardWithSpecificRank(cardKH, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardWitSameColorSameRankAce() {
    //     cardsPlayedBefore.add(cardAH);
    //     assertEquals(cardAH, AbstractGuest.playCardWithSpecificRank(cardAH, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColor2SH() {
    //     cardsPlayedBefore.add(card2S);
    //     assertEquals(card2S, AbstractGuest.playCardWithSpecificRank(card2S, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColor3SH() {
    //     cardsPlayedBefore.add(card3H);
    //     assertEquals(card3S, AbstractGuest.playCardWithSpecificRank(card3S, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColor4SH() {
    //     cardsPlayedBefore.add(card4H);
    //     assertEquals(card4S, AbstractGuest.playCardWithSpecificRank(card4S, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColor5SH() {
    //     cardsPlayedBefore.add(card5H);
    //     assertEquals(card5S, AbstractGuest.playCardWithSpecificRank(card5S, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColor6SH() {
    //     cardsPlayedBefore.add(card6H);
    //     playedCard.add(card6S);
    //     assertEquals(card6S, AbstractGuest.playCardWithSpecificRank(card6S, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColor7SH() {
    //     cardsPlayedBefore.add(card7H);
    //     assertEquals(card7S, AbstractGuest.playCardWithSpecificRank(card7S, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColor8SH() {
    //     cardsPlayedBefore.add(card8H);
    //     assertEquals(card8S, AbstractGuest.playCardWithSpecificRank(card8S, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColor9SH() {
    //     cardsPlayedBefore.add(card9H);
    //     assertEquals(card9S, AbstractGuest.playCardWithSpecificRank(card9S, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColor10SH() {
    //     cardsPlayedBefore.add(card10H);
    //     assertEquals(card10S, AbstractGuest.playCardWithSpecificRank(card10S, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColorJSH() {
    //     cardsPlayedBefore.add(cardJH);
    //     assertEquals(cardJS, AbstractGuest.playCardWithSpecificRank(cardJS, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColorQSH() {
    //     cardsPlayedBefore.add(cardQH);
    //     assertEquals(cardQS, AbstractGuest.playCardWithSpecificRank(cardQS, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColorKSH() {
    //     cardsPlayedBefore.add(cardKH);
    //     assertEquals(cardKS, AbstractGuest.playCardWithSpecificRank(cardKS, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColorAceSH() {
    //     cardsPlayedBefore.add(cardAH);
    //     assertEquals(cardAS, AbstractGuest.playCardWithSpecificRank(cardAS, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColor2SC() {
    //     cardsPlayedBefore.add(card2C);
    //     assertEquals(card2S, AbstractGuest.playCardWithSpecificRank(card2S, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColor3SC() {
    //     cardsPlayedBefore.add(card3C);
    //     assertEquals(card3S, AbstractGuest.playCardWithSpecificRank(card3S, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColor4SC() {
    //     cardsPlayedBefore.add(card4C);
    //     assertEquals(card4S, AbstractGuest.playCardWithSpecificRank(card4S, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColor5SC() {
    //     cardsPlayedBefore.add(card5C);
    //     assertEquals(card5S, AbstractGuest.playCardWithSpecificRank(card5S, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColor6SC() {
    //     cardsPlayedBefore.add(card6C);
    //     assertEquals(card6S, AbstractGuest.playCardWithSpecificRank(card6S, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColor7SC() {
    //     cardsPlayedBefore.add(card7C);
    //     assertEquals(card7S, AbstractGuest.playCardWithSpecificRank(card7S, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColor8SC() {
    //     cardsPlayedBefore.add(card8C);
    //     assertEquals(card8S, AbstractGuest.playCardWithSpecificRank(card8S, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColor9SC() {
    //     cardsPlayedBefore.add(card9C);
    //     assertEquals(card9S, AbstractGuest.playCardWithSpecificRank(card9S, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColor10SC() {
    //     cardsPlayedBefore.add(card10C);
    //     assertEquals(card10S, AbstractGuest.playCardWithSpecificRank(card10S, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColorJSC() {
    //     cardsPlayedBefore.add(cardJC);
    //     assertEquals(cardJS, AbstractGuest.playCardWithSpecificRank(cardJS, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColorQSC() {
    //     cardsPlayedBefore.add(cardQC);
    //     assertEquals(cardQS, AbstractGuest.playCardWithSpecificRank(cardQS, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColorKSC() {
    //     cardsPlayedBefore.add(cardKC);
    //     assertEquals(cardKS, AbstractGuest.playCardWithSpecificRank(cardKS, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColorAceSC() {
    //     cardsPlayedBefore.add(cardAC);
    //     assertEquals(cardAS, AbstractGuest.playCardWithSpecificRank(cardAS, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColor2SD() {
    //     cardsPlayedBefore.add(card2D);
    //     assertEquals(card2S, AbstractGuest.playCardWithSpecificRank(card2S, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColor3SD() {
    //     cardsPlayedBefore.add(card3D);
    //     assertEquals(card3S, AbstractGuest.playCardWithSpecificRank(card3S, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColor4SD() {
    //     cardsPlayedBefore.add(card4D);
    //     assertEquals(card4S, AbstractGuest.playCardWithSpecificRank(card4S, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColor5SD() {
    //     cardsPlayedBefore.add(card5D);
    //     assertEquals(card5S, AbstractGuest.playCardWithSpecificRank(card5S, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColor6SD() {
    //     cardsPlayedBefore.add(card6D);
    //     assertEquals(card6S, AbstractGuest.playCardWithSpecificRank(card6S, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColor7SD() {
    //     cardsPlayedBefore.add(card7D);
    //     assertEquals(card7S, AbstractGuest.playCardWithSpecificRank(card7S, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColor8SD() {
    //     cardsPlayedBefore.add(card8D);
    //     assertEquals(card8S, AbstractGuest.playCardWithSpecificRank(card8S, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColor9SD() {
    //     cardsPlayedBefore.add(card9D);
    //     assertEquals(card9S, AbstractGuest.playCardWithSpecificRank(card9S, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColor10SD() {
    //     cardsPlayedBefore.add(card10D);
    //     assertEquals(card10S, AbstractGuest.playCardWithSpecificRank(card10S, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColorJSD() {
    //     cardsPlayedBefore.add(cardJD);
    //     assertEquals(cardJS, AbstractGuest.playCardWithSpecificRank(cardJS, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColorQSD() {
    //     cardsPlayedBefore.add(cardQD);
    //     assertEquals(cardQS, AbstractGuest.playCardWithSpecificRank(cardQS, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColorKSD() {
    //     cardsPlayedBefore.add(cardKD);
    //     assertEquals(cardKS, AbstractGuest.playCardWithSpecificRank(cardKS, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playCardSameRankDifferentColorAceSD() {
    //     cardsPlayedBefore.add(cardAD);
    //     assertEquals(cardAS, AbstractGuest.playCardWithSpecificRank(cardAS, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playTheFirstCard3H() {
    //     cardsPlayedBefore.add(card3H);
    //     assertEquals(cardAS, AbstractGuest.playTheFirstCard(cardAS, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playTheFirstCard3D() {
    //     cardsPlayedBefore.add(card3D);
    //     assertEquals(cardAS, AbstractGuest.playTheFirstCard(cardAS, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playTheFirstCardAS3() {
    //     cardsPlayedBefore.add(card3C);
    //     assertEquals(cardAS, AbstractGuest.playTheFirstCard(cardAS, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playTheFirstCardDifferentRankSameColor2S3() {
    //     cardsPlayedBefore.add(card3S);
    //     assertEquals(card2S, AbstractGuest.playTheFirstCard(card2S, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playTheFirstCardDifferentRankSameColor2C3() {
    //     cardsPlayedBefore.add(card3C);
    //     assertEquals(card2C, AbstractGuest.playTheFirstCard(card2C, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playTheFirstCardDifferentRankSameColor2D3() {
    //     cardsPlayedBefore.add(card3D);
    //     assertEquals(card2D, AbstractGuest.playTheFirstCard(card2D, cardsPlayedBefore));
    //     hand.clear();
    // }

    // @Test
    // public void playTheFirstCardDifferentRankSameColor2H3() {
    //     cardsPlayedBefore.add(card3H);
    //     assertEquals(card2H, AbstractGuest.playTheFirstCard(card2H, cardsPlayedBefore));
    //     hand.clear();

    // }

}
