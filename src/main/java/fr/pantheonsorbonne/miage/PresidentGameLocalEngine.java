package fr.pantheonsorbonne.miage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import fr.pantheonsorbonne.miage.enums.CardColor;
import fr.pantheonsorbonne.miage.enums.CardValue;
import fr.pantheonsorbonne.miage.game.Card;
import fr.pantheonsorbonne.miage.game.Deck;
import fr.pantheonsorbonne.miage.game.PlayerResponse;
import fr.pantheonsorbonne.miage.model.Game;

public class PresidentGameLocalEngine extends PresidentGameEngine {

    public PresidentGameLocalEngine(Game president, Map<String, PresidentGameLocalPlayer> localPlayers) {
        this.president = president;
        this.localPlayers = localPlayers;
    }

    private static List<String> listPlayers = Arrays.asList("Kenz", "Aurelie", "Bilele", "Adrien");
    private Map<String, PresidentGameLocalPlayer> localPlayers;
    private static List<String> knownGuestImpl = Arrays.asList("GuestAdrien");

    public static void main(String[] args) {
        
        if (args.length != 1){
            System.err.println("Usage : PresidentGameLocalEngine [guest implementation]");
            System.exit(1);
        }


        if (! knownGuestImpl.contains(args[0])) {
            System.err.println("Unknown guest implementation");
            System.exit(1);
        }
        
        Map<String, PresidentGameLocalPlayer> localPlayers = new HashMap<>();
        for (String player:listPlayers) {
            localPlayers.put(player, new PresidentGameLocalPlayer(player, getGuestImpl(args[0])));
        }


        // create Game with players
        HashSet<String> players = new HashSet<>();
        players.addAll(listPlayers);
        Game president = new Game("president-jeu1", "president", "groupe E", players, Game.GameState.CREATED);
        
        // create local engine
        PresidentGameLocalEngine local = new PresidentGameLocalEngine(president, localPlayers);

        // play
        local.play();
    }

    private static Guest getGuestImpl(String guestImpl) {
        Guest guest = null;
        switch(guestImpl) {
            case "GuestAdrien":
                guest = new GuestAdrien();
                break;
        }
        return guest;
    }

    @Override
    public void giveCardsToPlayers(Game president, Deck deck) {
        int nbCards = deck.getDeckSize()/president.getPlayers().size();
        for (String playerName : president.getPlayers()) {
            Card[] cardsToGive = deck.giveCards(nbCards);
            String cardsString = Card.cardsToString(cardsToGive);
            PresidentGameLocalPlayer localPlayer = localPlayers.get(playerName);
            localPlayer.setHand(cardsToGive);
            System.out.println("Send "+cardsString+" to "+playerName);
        }
    }

    @Override
    public void askForQueenOfHeart() {
        Card queenOfHeart = new Card(CardColor.HEART, CardValue.QUEEN);
        for(PresidentGameLocalPlayer localPlayer : localPlayers.values()){
            if (localPlayer.getHand().contains(queenOfHeart)){
                setFirstPlayer(localPlayer.getPlayerName());
            }
        }
    }

    @Override
    public void handleResponseToQueenOfHeart(){
        System.out.println(getFirstPlayer()+ " starts the game");
        getPlayers().add(getFirstPlayer());
        for (String player:president.getPlayers()){
            if (!player.equals(getFirstPlayer())){
                getPlayers().add(player);
            }
        }
        System.out.println(getPlayers());
    }

    @Override
    public void exchangeCards() {
        PresidentGameLocalPlayer scumbag = localPlayers.get(winners.pollFirst());
        Card[] scumbagBestCards = scumbag.chooseBestCardsToGive(2);

        PresidentGameLocalPlayer president = localPlayers.get(winners.pollFirst());
        Card[] presidentCardsChoosed = president.chooseCardsOfYourChoiceToGive(2);
   
        scumbag.addCardsToHand(presidentCardsChoosed);
        president.addCardsToHand(scumbagBestCards);

        PresidentGameLocalPlayer viceScumbag = localPlayers.get(winners.pollFirst());
        Card[] viceScumbagBestCards = viceScumbag.chooseBestCardsToGive(1);
 
        PresidentGameLocalPlayer vicePresident = localPlayers.get(winners.pollLast());
        Card[] vicePresidentCardsChoosed = vicePresident.chooseCardsOfYourChoiceToGive(1);

        viceScumbag.addCardsToHand(vicePresidentCardsChoosed);
        vicePresident.addCardsToHand(viceScumbagBestCards);

        winners.clear();
    }

    @Override
    public PlayerResponse getCardFromPlayer(String player) {
        PresidentGameLocalPlayer localPlayer = localPlayers.get(player);
        return localPlayer.playCards(new ArrayList<>(lastNMoves));
    }

    @Override
    public List<String> getPlayers() {
        return this.players;
    }



}
