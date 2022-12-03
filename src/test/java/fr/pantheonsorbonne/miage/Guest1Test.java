package fr.pantheonsorbonne.miage;

import fr.pantheonsorbonne.miage.game.Card;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


import static fr.pantheonsorbonne.miage.GuestTest.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


class Guest1Test {
    Guest1 guest1 = new Guest1();
    List<Card> cardsPlayedBefore = new ArrayList<>();
    List<Card> hand = new ArrayList<>();
    List<Card> playedCardTesting=new ArrayList<>();
    List<Card> playedCard = new ArrayList<>();

    @Test
    public void chooseOneCardSameAsPlayedBefore2H () {
        cardsPlayedBefore.add(GuestTest.card2H);
        hand.add(GuestTest.card2H);
        assertEquals(GuestTest.card2H ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBefore2S () {
        cardsPlayedBefore.add(GuestTest.card2S);
        hand.add(GuestTest.card2S);
        assertEquals(GuestTest.card2S ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBefore2D () {
        cardsPlayedBefore.add(GuestTest.card2D);
        hand.add(GuestTest.card2D);
        assertEquals(GuestTest.card2D ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBefore2C () {
        cardsPlayedBefore.add(GuestTest.card2C);
        hand.add(GuestTest.card2C);
        assertEquals(GuestTest.card2C ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }

    @Test
    public void chooseOneCardSameAsPlayedBefore3S () {
        cardsPlayedBefore.add(GuestTest.card3S);
        hand.add(GuestTest.card3S);
        assertEquals(GuestTest.card3S ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }

    @Test
    public void chooseOneCardSameAsPlayedBefore3H () {
        cardsPlayedBefore.add(GuestTest.card3H);
        hand.add(GuestTest.card3H);
        assertEquals(GuestTest.card3H ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }

    @Test
    public void chooseOneCardSameAsPlayedBefore3C() {
        cardsPlayedBefore.add(GuestTest.card3C);
        hand.add(GuestTest.card3C);
        assertEquals(GuestTest.card3C ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBefore3D() {
        cardsPlayedBefore.add(GuestTest.card3D);
        hand.add(GuestTest.card3D);
        assertEquals(GuestTest.card3D ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }

    @Test
    public void chooseOneCardSameAsPlayedBefore4S() {
        cardsPlayedBefore.add(GuestTest.card4S);
        hand.add(GuestTest.card4S);
        assertEquals(GuestTest.card4S ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBefore4C() {
        cardsPlayedBefore.add(GuestTest.card4C);
        hand.add(GuestTest.card4C);
        assertEquals(GuestTest.card4C ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBefore4D() {
        cardsPlayedBefore.add(GuestTest.card4D);
        hand.add(GuestTest.card4D);
        assertEquals(GuestTest.card4D ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBefore4H() {
        cardsPlayedBefore.add(GuestTest.card4H);
        hand.add(GuestTest.card4H);
        assertEquals(GuestTest.card4H ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBefore5S() {
        cardsPlayedBefore.add(GuestTest.card5S);
        hand.add(GuestTest.card5S);
        assertEquals(GuestTest.card5S ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBefore5H() {
        cardsPlayedBefore.add(GuestTest.card5H);
        hand.add(GuestTest.card5H);
        assertEquals(GuestTest.card5H ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }

    @Test
    public void chooseOneCardSameAsPlayedBefore5D() {
        cardsPlayedBefore.add(GuestTest.card5D);
        hand.add(GuestTest.card5D);
        assertEquals(GuestTest.card5D ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBefore5C() {
        cardsPlayedBefore.add(GuestTest.card5C);
        hand.add(GuestTest.card5C);
        assertEquals(GuestTest.card5C ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBefore6S() {
        cardsPlayedBefore.add(GuestTest.card6S);
        hand.add(GuestTest.card6S);
        assertEquals(GuestTest.card6S ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBefore6D() {
        cardsPlayedBefore.add(GuestTest.card6D);
        hand.add(GuestTest.card6D);
        assertEquals(GuestTest.card6D,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBefore6H() {
        cardsPlayedBefore.add(GuestTest.card6H);
        hand.add(GuestTest.card6H);
        assertEquals(GuestTest.card6H ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBefore6C() {
        cardsPlayedBefore.add(GuestTest.card6C);
        hand.add(GuestTest.card6C);
        assertEquals(GuestTest.card6C ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBefore7S() {
        cardsPlayedBefore.add(GuestTest.card7S);
        hand.add(GuestTest.card7S);
        assertEquals(GuestTest.card7S ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBefore7H() {
        cardsPlayedBefore.add(GuestTest.card7H);
        hand.add(GuestTest.card7H);
        assertEquals(GuestTest.card7H ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBefore7D() {
        cardsPlayedBefore.add(GuestTest.card7D);
        hand.add(GuestTest.card7D);
        assertEquals(GuestTest.card7D ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBefore7C() {
        cardsPlayedBefore.add(GuestTest.card7C);
        hand.add(GuestTest.card7C);
        assertEquals(GuestTest.card7C ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBefore8S() {
        cardsPlayedBefore.add(GuestTest.card8S);
        hand.add(GuestTest.card8S);
        assertEquals(GuestTest.card8S ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBefore8H() {
        cardsPlayedBefore.add(GuestTest.card8H);
        hand.add(GuestTest.card8H);
        assertEquals(GuestTest.card8H ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBefore8D() {
        cardsPlayedBefore.add(GuestTest.card8D);
        hand.add(GuestTest.card8D);
        assertEquals(GuestTest.card8D ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBefore8C() {
        cardsPlayedBefore.add(GuestTest.card8C);
        hand.add(GuestTest.card8C);
        assertEquals(GuestTest.card8C ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBefore9S() {
        cardsPlayedBefore.add(GuestTest.card9S);
        hand.add(GuestTest.card9S);
        assertEquals(GuestTest.card9S ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBefore9C() {
        cardsPlayedBefore.add(GuestTest.card9C);
        hand.add(GuestTest.card9C);
        assertEquals(GuestTest.card9C ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBefore9H() {
        cardsPlayedBefore.add(GuestTest.card9H);
        hand.add(GuestTest.card9H);
        assertEquals(GuestTest.card9H ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBefore9D() {
        cardsPlayedBefore.add(GuestTest.card9D);
        hand.add(GuestTest.card9D);
        assertEquals(GuestTest.card9D ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBefore10S() {
        cardsPlayedBefore.add(GuestTest.card10S);
        hand.add(GuestTest.card10S);
        assertEquals(GuestTest.card10S ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }

    @Test
    public void chooseOneCardSameAsPlayedBefore10C() {
        cardsPlayedBefore.add(GuestTest.card10C);
        hand.add(GuestTest.card10C);
        assertEquals(GuestTest.card10C ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }

    @Test
    public void chooseOneCardSameAsPlayedBefore10D() {
        cardsPlayedBefore.add(GuestTest.card10D);
        hand.add(GuestTest.card10D);
        assertEquals(GuestTest.card10D ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBefore10H() {
        cardsPlayedBefore.add(GuestTest.card10H);
        hand.add(GuestTest.card10H);
        assertEquals(GuestTest.card10H ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBeforeJH() {
        cardsPlayedBefore.add(GuestTest.cardJH);
        hand.add(GuestTest.cardJH);
        assertEquals(GuestTest.cardJH ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBeforeJC() {
        cardsPlayedBefore.add(GuestTest.cardJC);
        hand.add(GuestTest.cardJC);
        assertEquals(GuestTest.cardJC ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBeforeJD() {
        cardsPlayedBefore.add(GuestTest.cardJD);
        hand.add(GuestTest.cardJD);
        assertEquals(GuestTest.cardJD ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBeforeJS() {
        cardsPlayedBefore.add(GuestTest.cardJS);
        hand.add(GuestTest.cardJS);
        assertEquals(GuestTest.cardJS ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBeforeQH() {
        cardsPlayedBefore.add(GuestTest.cardQH);
        hand.add(GuestTest.cardQH);
        assertEquals(GuestTest.cardQH ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBeforeQS() {
        cardsPlayedBefore.add(GuestTest.cardQS);
        hand.add(GuestTest.cardQS);
        assertEquals(GuestTest.cardQS ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBeforeQC() {
        cardsPlayedBefore.add(GuestTest.cardQC);
        hand.add(GuestTest.cardQC);
        assertEquals(GuestTest.cardQC ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBeforeQD() {
        cardsPlayedBefore.add(GuestTest.cardQD);
        hand.add(GuestTest.cardQD);
        assertEquals(GuestTest.cardQD ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBeforeKD() {
        cardsPlayedBefore.add(GuestTest.cardKD);
        hand.add(GuestTest.cardKD);
        assertEquals(GuestTest.cardKD ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBeforeKS() {
        cardsPlayedBefore.add(GuestTest.cardKS);
        hand.add(GuestTest.cardKS);
        assertEquals(GuestTest.cardKS ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }

    @Test
    public void chooseOneCardSameAsPlayedBeforeKC() {
        cardsPlayedBefore.add(GuestTest.cardKC);
        hand.add(GuestTest.cardKC);
        assertEquals(GuestTest.cardKC ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBeforeKH() {
        cardsPlayedBefore.add(GuestTest.cardKH);
        hand.add(GuestTest.cardKH);
        assertEquals(GuestTest.cardKH ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBeforeAH() {
        cardsPlayedBefore.add(GuestTest.cardAH);
        hand.add(GuestTest.cardAH);
        assertEquals(GuestTest.cardAH ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBeforeAC() {
        cardsPlayedBefore.add(cardAC);
        hand.add(cardAC);
        assertEquals(cardAC ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBeforeAS() {
        cardsPlayedBefore.add(GuestTest.cardAS);
        hand.add(GuestTest.cardAS);
        assertEquals(GuestTest.cardAS ,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }
    @Test
    public void chooseOneCardSameAsPlayedBeforeAD() {
        cardsPlayedBefore.add(GuestTest.cardAD);
        hand.add(GuestTest.cardAD);
        assertEquals(GuestTest.cardAD,guest1.chooseOneCard(cardsPlayedBefore,hand));
    }

    @Test
    public void chooseManyCardsSameRankA(){
        cardsPlayedBefore.add(cardAD);
        hand.add(GuestTest.cardAS);
        hand.add(cardAC);
        playedCardTesting.add(cardAS);
        playedCardTesting.add(cardAC);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsSameRank2(){
        cardsPlayedBefore.add(card2D);
        hand.add(card2C);
        hand.add(card2S);
        playedCardTesting.add(card2C);
        playedCardTesting.add(card2S);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsSameRank3(){
        cardsPlayedBefore.add(card3D);
        hand.add(card3S);
        hand.add(card3C);
        playedCardTesting.add(card3S);
        playedCardTesting.add(card3C);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsSameRank4(){
        cardsPlayedBefore.add(card4D);
        hand.add(card4S);
        hand.add(card4C);
        playedCardTesting.add(card4S);
        playedCardTesting.add(card4C);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsSameRank5(){
        cardsPlayedBefore.add(card5D);
        hand.add(GuestTest.card5S);
        hand.add(card5C);
        playedCardTesting.add(card5S);
        playedCardTesting.add(card5C);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsSameRank6(){
        cardsPlayedBefore.add(card6D);
        hand.add(GuestTest.card6S);
        hand.add(card6C);
        playedCardTesting.add(card6S);
        playedCardTesting.add(card6C);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }  @Test
    public void chooseManyCardsSameRank7(){
        cardsPlayedBefore.add(card7D);
        hand.add(GuestTest.card7S);
        hand.add(card7C);
        playedCardTesting.add(card7S);
        playedCardTesting.add(card7C);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsSameRank8(){
        cardsPlayedBefore.add(card8D);
        hand.add(GuestTest.card8S);
        hand.add(card8C);
        playedCardTesting.add(card8S);
        playedCardTesting.add(card8C);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsSameRank9(){
        cardsPlayedBefore.add(card9D);
        hand.add(GuestTest.card9S);
        hand.add(card9C);
        playedCardTesting.add(card9S);
        playedCardTesting.add(card9C);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsSameRank10(){
        cardsPlayedBefore.add(card10D);
        hand.add(GuestTest.card10C);
        hand.add(card10S);
        playedCardTesting.add(card10C);
        playedCardTesting.add(card10S);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsSameRankJ(){
        cardsPlayedBefore.add(cardJD);
        hand.add(GuestTest.cardJC);
        hand.add(cardJS);
        playedCardTesting.add(cardJC);
        playedCardTesting.add(cardJS);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsSameRankQ(){
        cardsPlayedBefore.add(cardQD);
        hand.add(GuestTest.cardQC);
        hand.add(cardQS);
        playedCardTesting.add(cardQC);
        playedCardTesting.add(cardQS);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
        guest1.chooseManyCards(cardsPlayedBefore,hand,2).clear();
    }
    @Test
    public void chooseManyCardsSameRankK(){
        cardsPlayedBefore.add(cardKD);
        hand.add(GuestTest.cardKS);
        hand.add(cardKD);
        playedCardTesting.add(cardKS);
        playedCardTesting.add(cardKD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
        guest1.chooseManyCards(cardsPlayedBefore,hand,2).clear();
    }

    @Test
    public void chooseManyCardsDifferentRank2A(){
        cardsPlayedBefore.add(cardAD);
        hand.add(card2S);
        hand.add(card2D);
        playedCardTesting.add(card2S);
        playedCardTesting.add(card2D);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
        guest1.chooseManyCards(cardsPlayedBefore,hand,2).clear();
    }
    @Test
    public void chooseManyCardsDifferentRank23(){
        cardsPlayedBefore.add(card3D);
        hand.add(card2S);
        hand.add(card2D);
        playedCardTesting.add(card2S);
        playedCardTesting.add(card2D);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
        guest1.chooseManyCards(cardsPlayedBefore,hand,2).clear();
    }
    @Test
    public void chooseManyCardsDifferentRank24(){
        cardsPlayedBefore.add(card4D);
        hand.add(card2S);
        hand.add(card2D);
        playedCardTesting.add(card2S);
        playedCardTesting.add(card2D);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
        guest1.chooseManyCards(cardsPlayedBefore,hand,2).clear();
        hand.clear();

    }

    @Test
    public void chooseManyCardsDifferentRank25(){
        cardsPlayedBefore.add(card5D);
        hand.add(card2S);
        hand.add(card2D);
        playedCardTesting.add(card2S);
        playedCardTesting.add(card2D);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
        guest1.chooseManyCards(cardsPlayedBefore,hand,2).clear();
        hand.clear();
    }
    @Test
    public void chooseManyCardsDifferentRank26(){
        playedCard.clear();
        cardsPlayedBefore.add(card6D);
        hand.add(card2S);
        hand.add(card2D);
        hand.add(card2C);
        hand.add(card2H);
        hand.add(card3D);
        playedCardTesting.add(card2S);
        playedCardTesting.add(card2D);
        playedCardTesting.add(card2C);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,3));
        hand.clear();
    }
    @Test
    public void chooseManyCardsDifferentRank27(){
        cardsPlayedBefore.add(card7D);
        hand.add(card2S);
        hand.add(card2D);
        playedCardTesting.add(card2S);
        playedCardTesting.add(card2D);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
        guest1.chooseManyCards(cardsPlayedBefore,hand,2).clear();
    }
    @Test
    public void chooseManyCardsDifferentRank28(){
        cardsPlayedBefore.add(card8D);
        hand.add(card2S);
        hand.add(card2D);
        playedCardTesting.add(card2S);
        playedCardTesting.add(card2D);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
        guest1.chooseManyCards(cardsPlayedBefore,hand,2).clear();
    }
    @Test
    public void chooseManyCardsDifferentRank29(){
        cardsPlayedBefore.add(card9D);
        hand.add(card2S);
        hand.add(card2D);
        playedCardTesting.add(card2S);
        playedCardTesting.add(card2D);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
        guest1.chooseManyCards(cardsPlayedBefore,hand,2).clear();
    }
    @Test
    public void chooseManyCardsDifferentRank210(){
        cardsPlayedBefore.add(card10D);
        hand.add(card2S);
        hand.add(card2D);
        playedCardTesting.add(card2S);
        playedCardTesting.add(card2D);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
        guest1.chooseManyCards(cardsPlayedBefore,hand,2).clear();
    }
    @Test
    public void chooseManyCardsDifferentRank2J(){
        cardsPlayedBefore.add(cardJD);
        hand.add(card2S);
        hand.add(card2D);
        playedCardTesting.add(card2S);
        playedCardTesting.add(card2D);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
        guest1.chooseManyCards(cardsPlayedBefore,hand,2).clear();
    }
    @Test
    public void chooseManyCardsDifferentRank2Q(){
        cardsPlayedBefore.add(cardQD);
        hand.add(card2S);
        hand.add(card2D);
        playedCardTesting.add(card2S);
        playedCardTesting.add(card2D);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRank2K(){
        cardsPlayedBefore.add(cardKD);
        hand.add(card2S);
        hand.add(card2D);
        playedCardTesting.add(card2S);
        playedCardTesting.add(card2D);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRankA3(){
        cardsPlayedBefore.add(card3D);
        hand.add(cardAS);
        hand.add(cardAD);
        playedCardTesting.add(cardAS);
        playedCardTesting.add(cardAD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRankA4(){
        cardsPlayedBefore.add(card4D);
        hand.add(cardAS);
        hand.add(cardAD);
        playedCardTesting.add(cardAS);
        playedCardTesting.add(cardAD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRankA5(){
        cardsPlayedBefore.add(card5D);
        hand.add(cardAS);
        hand.add(cardAD);
        playedCardTesting.add(cardAS);
        playedCardTesting.add(cardAD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRankA6(){
        cardsPlayedBefore.add(card6D);
        hand.add(cardAS);
        hand.add(cardAD);
        playedCardTesting.add(cardAS);
        playedCardTesting.add(cardAD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }

    @Test
    public void chooseManyCardsDifferentRankA7(){
        cardsPlayedBefore.add(card7D);
        hand.add(cardAS);
        hand.add(cardAD);
        playedCardTesting.add(cardAS);
        playedCardTesting.add(cardAD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRankA8(){
        cardsPlayedBefore.add(card8D);
        hand.add(cardAS);
        hand.add(cardAD);
        playedCardTesting.add(cardAS);
        playedCardTesting.add(cardAD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRankA9(){
        cardsPlayedBefore.add(card9D);
        hand.add(cardAS);
        hand.add(cardAD);
        playedCardTesting.add(cardAS);
        playedCardTesting.add(cardAD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRankA10(){
        cardsPlayedBefore.add(card10D);
        hand.add(cardAS);
        hand.add(cardAD);
        playedCardTesting.add(cardAS);
        playedCardTesting.add(cardAD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRankAJ(){
        cardsPlayedBefore.add(cardJD);
        hand.add(cardAS);
        hand.add(cardAD);
        playedCardTesting.add(cardAS);
        playedCardTesting.add(cardAD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRankAQ(){
        cardsPlayedBefore.add(cardQD);
        hand.add(cardAS);
        hand.add(cardAD);
        playedCardTesting.add(cardAS);
        playedCardTesting.add(cardAD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRankAK(){
        cardsPlayedBefore.add(cardKD);
        hand.add(cardAS);
        hand.add(cardAD);
        playedCardTesting.add(cardAS);
        playedCardTesting.add(cardAD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRankQ3(){
        cardsPlayedBefore.add(card3D);
        hand.add(cardQS);
        hand.add(cardQD);
        playedCardTesting.add(cardQS);
        playedCardTesting.add(cardQD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRankQ4(){
        cardsPlayedBefore.add(card4D);
        hand.add(cardQS);
        hand.add(cardQD);
        playedCardTesting.add(cardQS);
        playedCardTesting.add(cardQD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRankQ5(){
        cardsPlayedBefore.add(card5D);
        hand.add(cardQS);
        hand.add(cardQD);
        playedCardTesting.add(cardQS);
        playedCardTesting.add(cardQD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRankQ6(){
        cardsPlayedBefore.add(card6D);
        hand.add(cardQS);
        hand.add(cardQD);
        playedCardTesting.add(cardQS);
        playedCardTesting.add(cardQD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRankQ7(){
        cardsPlayedBefore.add(card7D);
        hand.add(cardQS);
        hand.add(cardQD);
        playedCardTesting.add(cardQS);
        playedCardTesting.add(cardQD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRankQ8(){
        cardsPlayedBefore.add(card8D);
        hand.add(cardQS);
        hand.add(cardQD);
        playedCardTesting.add(cardQS);
        playedCardTesting.add(cardQD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRankQ9(){
        cardsPlayedBefore.add(card9D);
        hand.add(cardQS);
        hand.add(cardQD);
        playedCardTesting.add(cardQS);
        playedCardTesting.add(cardQD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRankQ10(){
        cardsPlayedBefore.add(card10D);
        hand.add(cardQS);
        hand.add(cardQD);
        playedCardTesting.add(cardQS);
        playedCardTesting.add(cardQD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRankQJ(){
        cardsPlayedBefore.add(cardJD);
        hand.add(cardQS);
        hand.add(cardQD);
        playedCardTesting.add(cardQS);
        playedCardTesting.add(cardQD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRankK3(){
        cardsPlayedBefore.add(card3D);
        hand.add(cardKS);
        hand.add(cardKD);
        playedCardTesting.add(cardKS);
        playedCardTesting.add(cardKD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRankK4(){
        cardsPlayedBefore.add(card4D);
        hand.add(cardKS);
        hand.add(cardKD);
        playedCardTesting.add(cardKS);
        playedCardTesting.add(cardKD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRankK5(){
        cardsPlayedBefore.add(card5D);
        hand.add(cardKS);
        hand.add(cardKD);
        playedCardTesting.add(cardKS);
        playedCardTesting.add(cardKD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRankK6(){
        cardsPlayedBefore.add(card6D);
        hand.add(cardKS);
        hand.add(cardKD);
        playedCardTesting.add(cardKS);
        playedCardTesting.add(cardKD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRankK7(){
        cardsPlayedBefore.add(card7D);
        hand.add(cardKS);
        hand.add(cardKD);
        playedCardTesting.add(cardKS);
        playedCardTesting.add(cardKD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRankK8(){
        cardsPlayedBefore.add(card8D);
        hand.add(cardKS);
        hand.add(cardKD);
        playedCardTesting.add(cardKS);
        playedCardTesting.add(cardKD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRankK9(){
        cardsPlayedBefore.add(card9D);
        hand.add(cardKS);
        hand.add(cardKD);
        playedCardTesting.add(cardKS);
        playedCardTesting.add(cardKD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRankK10(){
        cardsPlayedBefore.add(card10D);
        hand.add(cardKS);
        hand.add(cardKD);
        playedCardTesting.add(cardKS);
        playedCardTesting.add(cardKD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRankKJ(){
        cardsPlayedBefore.add(cardJD);
        hand.add(cardKS);
        hand.add(cardKD);
        playedCardTesting.add(cardKS);
        playedCardTesting.add(cardKD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRankKQ(){
        cardsPlayedBefore.add(cardQD);
        hand.add(cardKS);
        hand.add(cardKD);
        playedCardTesting.add(cardKS);
        playedCardTesting.add(cardKD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRankJ3(){
        cardsPlayedBefore.add(card3D);
        hand.add(cardJS);
        hand.add(cardJD);
        playedCardTesting.add(cardJS);
        playedCardTesting.add(cardJD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }

    @Test
    public void chooseManyCardsDifferentRankJ4(){
        cardsPlayedBefore.add(card4D);
        hand.add(cardJS);
        hand.add(cardJD);
        playedCardTesting.add(cardJS);
        playedCardTesting.add(cardJD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRankJ5(){
        cardsPlayedBefore.add(card5D);
        hand.add(cardJS);
        hand.add(cardJD);
        playedCardTesting.add(cardJS);
        playedCardTesting.add(cardJD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRankJ6(){
        cardsPlayedBefore.add(card6D);
        hand.add(cardJS);
        hand.add(cardJD);
        playedCardTesting.add(cardJS);
        playedCardTesting.add(cardJD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRankJ7(){
        cardsPlayedBefore.add(card7D);
        hand.add(cardJS);
        hand.add(cardJD);
        playedCardTesting.add(cardJS);
        playedCardTesting.add(cardJD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRankJ8(){
        cardsPlayedBefore.add(card8D);
        hand.add(cardJS);
        hand.add(cardJD);
        playedCardTesting.add(cardJS);
        playedCardTesting.add(cardJD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRankJ9(){
        cardsPlayedBefore.add(card9D);
        hand.add(cardJS);
        hand.add(cardJD);
        playedCardTesting.add(cardJS);
        playedCardTesting.add(cardJD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRankJ10(){
        cardsPlayedBefore.add(card10D);
        hand.add(cardJS);
        hand.add(cardJD);
        playedCardTesting.add(cardJS);
        playedCardTesting.add(cardJD);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRank103(){
        cardsPlayedBefore.add(card3D);
        hand.add(card10S);
        hand.add(card10D);
        playedCardTesting.add(card10S);
        playedCardTesting.add(card10D);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRank104(){
        cardsPlayedBefore.add(card4D);
        hand.add(card10S);
        hand.add(card10D);
        playedCardTesting.add(card10S);
        playedCardTesting.add(card10D);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRank105(){
        cardsPlayedBefore.add(card5D);
        hand.add(card10S);
        hand.add(card10D);
        playedCardTesting.add(card10S);
        playedCardTesting.add(card10D);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRank106(){
        cardsPlayedBefore.add(card6D);
        hand.add(card10S);
        hand.add(card10D);
        playedCardTesting.add(card10S);
        playedCardTesting.add(card10D);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRank107(){
        cardsPlayedBefore.add(card7D);
        hand.add(card10S);
        hand.add(card10D);
        playedCardTesting.add(card10S);
        playedCardTesting.add(card10D);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRank108(){
        cardsPlayedBefore.add(card8D);
        hand.add(card10S);
        hand.add(card10D);
        playedCardTesting.add(card10S);
        playedCardTesting.add(card10D);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRank109(){
        cardsPlayedBefore.add(card9D);
        hand.add(card10S);
        hand.add(card10D);
        playedCardTesting.add(card10S);
        playedCardTesting.add(card10D);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRank83(){
        cardsPlayedBefore.add(card3D);
        hand.add(card8S);
        hand.add(card8D);
        playedCardTesting.add(card8S);
        playedCardTesting.add(card8D);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRank84(){
        cardsPlayedBefore.add(card4D);
        hand.add(card8S);
        hand.add(card8D);
        playedCardTesting.add(card8S);
        playedCardTesting.add(card8D);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRank85(){
        cardsPlayedBefore.add(card5D);
        hand.add(card8S);
        hand.add(card8D);
        playedCardTesting.add(card8S);
        playedCardTesting.add(card8D);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRank86(){
        cardsPlayedBefore.add(card6D);
        hand.add(card8S);
        hand.add(card8D);
        playedCardTesting.add(card8S);
        playedCardTesting.add(card8D);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }
    @Test
    public void chooseManyCardsDifferentRank87(){
        cardsPlayedBefore.add(card7D);
        hand.add(card8S);
        hand.add(card8D);
        playedCardTesting.add(card8S);
        playedCardTesting.add(card8D);
        assertEquals( playedCardTesting,guest1.chooseManyCards(cardsPlayedBefore,hand,2));
    }

}
