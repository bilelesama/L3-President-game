package fr.pantheonsorbonne.miage.game;

/**
 * Represents the response of the player when he plays 
 *
 */
public class PlayerResponse {
    private int nbOfCardsRemaining;
    private Card[] cards;

    public PlayerResponse(Card[] cards, int nbOfCardsRemaining){
        this.cards = cards;
        this.nbOfCardsRemaining = nbOfCardsRemaining;
    }

    public int getNbOfCardsRemaining(){
        return nbOfCardsRemaining;
    }

    public Card[] getCards(){
        return cards;
    }
}