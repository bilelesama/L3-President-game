package fr.pantheonsorbonne.miage;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.pantheonsorbonne.miage.enums.CardColor;
import fr.pantheonsorbonne.miage.enums.CardValue;
import fr.pantheonsorbonne.miage.game.Card;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void displayLastNMoves(){
        String lastMove = "6S#4H##3D";
        List<Card[]> lastMoveList = new ArrayList<>();
        String[] move = lastMove.split("#");
        for (int i=0; i<move.length; i++){
            Card[] card = Card.stringToCards(move[i]);
            lastMoveList.add(card);
        }
        
        Card sixSpade = new Card(CardColor.SPADE, CardValue.SIX);
  
        Assertions.assertEquals(1, lastMoveList.get(0).length);
        Assertions.assertEquals(sixSpade, lastMoveList.get(0)[0]);

        Assertions.assertEquals(0, lastMoveList.get(2).length);

    }

    @Test
    public void displayLastNMovesWithDouble(){
        String lastMove = "6S;6H#4H;4D##3D;3S";
        List<Card[]> lastMoveList = new ArrayList<>();
        String[] move = lastMove.split("#");
        for (int i=0; i<move.length; i++){
            Card[] card = Card.stringToCards(move[i]);
            lastMoveList.add(card);
        }
        
        Card sixSpade = new Card(CardColor.SPADE, CardValue.SIX);
        Card sixHeart = new Card(CardColor.HEART, CardValue.SIX);
        Card[] expectedCards = new Card[]{sixSpade, sixHeart};
        
        Assertions.assertArrayEquals(expectedCards, lastMoveList.get(0));
        
    }

}
