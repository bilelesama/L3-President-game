package fr.pantheonsorbonne.miage;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

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
        System.out.println("Voici les n derniers coups :");
        for (Card[] cardsPlayed : lastMoveList){
            System.out.println(Card.cardsToString(cardsPlayed));
        }
        
    }

}
