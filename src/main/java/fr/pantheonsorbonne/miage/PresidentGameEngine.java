package fr.pantheonsorbonne.miage;

import java.util.ArrayList;
import java.util.List;

import fr.pantheonsorbonne.miage.game.Deck;
import fr.pantheonsorbonne.miage.model.Game;

public abstract class PresidentGameEngine {

    protected final Game president = new Game();
    private final List<String> players = new ArrayList<>();
    
    private Deck deck = null;
    private String firstPlayer;

    private static final int NB_ROUNDS = 10;
    
    public void play() {
        deck = new Deck();
        giveCardsToPlayers(president, deck);
        // check who has the Queen of heart (wait all responses) -> reorder players list
        System.out.println("Who has the queen of heart ?");
        askForQueenOfHeart();
        handleResponseToQueenOfHeart();
        gameLoop();

        int cpt = 0;
        while (cpt < NB_ROUNDS -1){
            deck = new Deck();
            giveCardsToPlayers(president, deck);
            exchangeCards();
            gameLoop();
        }
        gameOver();
    }

    public abstract void askForQueenOfHeart();

    public abstract void handleResponseToQueenOfHeart() ;

    public abstract void gameLoop() ;

    public abstract void giveCardsToPlayers(Game president2, Deck deck2) ;

    public abstract void exchangeCards() ;

    public abstract void gameOver() ;

    public List<String> getPlayers() {
        return this.players;
    }
    
    public String getPlayerName(String playerId) {
        return playerId.split("#")[0];
    }

    public void setFirstPlayer(String playerId) {
        this.firstPlayer = playerId;
        System.out.println("The first player is " + getPlayerName(firstPlayer));
    }

    public String getFirstPlayer(){
        return firstPlayer;
    }

    

    

    
}
