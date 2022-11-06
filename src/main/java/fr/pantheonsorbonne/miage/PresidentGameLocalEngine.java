package fr.pantheonsorbonne.miage;

import java.util.Arrays;
import java.util.HashSet;

import fr.pantheonsorbonne.miage.game.Card;
import fr.pantheonsorbonne.miage.game.Deck;
import fr.pantheonsorbonne.miage.model.Game;

public class PresidentGameLocalEngine extends PresidentGameNetworkEngine {

    public PresidentGameLocalEngine(HostFacade hostFacade, Game president) {
        super(hostFacade, president);
        //TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        
        // create Game with players
        HashSet<String> players = new HashSet<>();
        players.addAll(Arrays.asList("Kenz", "Aurelie", "Bilel", "Adrien"));
        Game president = new Game("president1", "president", "groupe E", players, Game.GameState.CREATED);
        
        // create local engine
        PresidentGameLocalEngine host = new PresidentGameLocalEngine(null, president);
        // play
        host.play();
        System.out.println("Who has the queen of heart ?");
        
    }

    @Override
    protected void giveCardsToPlayers(Game president, Deck deck) {
        int nbCards = deck.getDeckSize()/president.getPlayers().size();
        for (String playerName : president.getPlayers()) {
            Card[] cardsToGive = deck.giveCards(nbCards);
            String cardsString = Card.cardsToString(cardsToGive);
            if (cardsString.contains("H Q")){
                setFirstPlayer(playerName);
            }
            System.out.println("Send "+cardsString+" to "+playerName);
        }
        
    }

    @Override
    protected void handleResponseToQueenOfHeart(){
        System.out.println(getFirstPlayer()+ " starts the game");
        //reorder the list
    }
}
