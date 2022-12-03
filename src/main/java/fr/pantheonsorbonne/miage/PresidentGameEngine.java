package fr.pantheonsorbonne.miage;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

import fr.pantheonsorbonne.miage.enums.CardValue;
import fr.pantheonsorbonne.miage.game.Card;
import fr.pantheonsorbonne.miage.game.Deck;
import fr.pantheonsorbonne.miage.game.PlayerResponse;
import fr.pantheonsorbonne.miage.model.Game;

public abstract class PresidentGameEngine {

    protected Game president;
    protected final List<String> players = new ArrayList<>();

    /** winners needs to be a LinkedHashSet so we can keep the seizure order
    * this will help when roles will be displayed **/
    protected final Deque<String> winners = new ArrayDeque<>();

    /* playersStillPlaying keeps the players name and the play order */
    protected final Set<String> playersStillPlaying = new LinkedHashSet<>();
    
    private int nbPlayers = 4; 
    private int nbRounds = 10;

    protected String firstPlayer;
    private boolean endsWithTwo = false; 
    private boolean isPresident = false;
    private String closedPlayer = "";

    protected Deque<Card[]> lastNMoves = new ArrayDeque<>();
    private Map<CardValue, Integer> squareCounter = new HashMap<>();
    private Map<String, Integer> presidentCounter = new HashMap<>();
    
    protected void play() {
        Deck deck = new Deck();
        giveCardsToPlayers(president, deck);
        // check who has the Queen of heart (wait all responses) -> reorder players list
        System.out.println("Who has the queen of heart ?");
        askForQueenOfHeart();
        handleResponseToQueenOfHeart();
        gameLoop();

        System.out.println("end of first round");
        int cpt = 1;
        while (cpt < nbRounds){
            cpt++;
            deck = new Deck();
            giveCardsToPlayers(president, deck);
            resetListAndCounter();
            exchangeCards();
            gameLoop();
            System.out.println("end of round " + cpt);
        }
        gameOver();
    }

    public abstract void askForQueenOfHeart();

    public abstract void handleResponseToQueenOfHeart() ;

    protected void gameLoop(){
        playersStillPlaying.addAll(players);
        while (playersStillPlaying.size() > 1){
            for (String player : getPlayers()){
                if(skipPlayerWhenClose(player)) {
                    continue;
                }
                if (playersStillPlaying.contains(player)){
                    playerPlay(player);
                }
            }
        }
        // end of while loop, playersStillPlaying should contains only one player (the last one)
        System.out.printf("playersStillPlaying.size() %d - [%s]%n", playersStillPlaying.size(), playersStillPlaying);
        winners.addAll(playersStillPlaying);
        if (!endsWithTwo){
            String scumbag = winners.pollLast();
            winners.addFirst(scumbag);
        }   
        System.out.println("order for new round : "+winners);
    }

    protected boolean skipPlayerWhenClose(String player) {
        if (closedPlayer.isEmpty()){
            return false;
        } 
        else if(!player.equals(closedPlayer)){
            return true;
        }
        else{
            closedPlayer = "";
            return false;
        }
    }

    protected void playerPlay(String player) {
        PlayerResponse response = getCardFromPlayer(player);
        updateLastNMoves(response);
        System.out.println("lastNmoves : ");
        lastNMoves.forEach(m -> System.out.println(Card.cardsToString(m)));
        updateSquareCounter();
        //check if the player ends his hand
        if (response.getNbOfCardsRemaining() == 0){
            //if the last card is a 2, the player is the Scumbag
            if (endsWithTwo()){
                System.out.println(getPlayerName(player)+" ends with two");
                winners.addFirst(player); 
                endsWithTwo = true;
            }
            else {
                System.out.println(getPlayerName(player)+" ends");
                addWinners(player);
            }
            playersStillPlaying.remove(player);

            //if he is the first player to finish : reset the pile 
            if (winners.size() == 1){
                isPresident = true;
                presidentCounter.merge(player, 1, Integer::sum);
            }
            System.out.println("winners.size : "+winners.size() + " playersStillPlaying.size(): " + playersStillPlaying.size());
        }
        //check if the serie is finished
        if (isClosed(isPresident)){
            System.out.println("round is closed");
            lastNMoves.clear();
            isPresident = false;
            closedPlayer = player; 
        }  
    }

    public abstract PlayerResponse getCardFromPlayer(String player);

    protected boolean isClosed(boolean isPresident){
        System.out.printf("endsWithTwo: %s - isSquare: %s - noOneCanPlay: %s - isPresident: %s%n", endsWithTwo(), isSquare(), noOneCanPlay(), isPresident);
        return endsWithTwo() || isSquare() || noOneCanPlay() || isPresident ;
    }

    protected boolean endsWithTwo(){
        if (lastNMoves.getFirst().length > 0){
            return CardValue.TWO.equals(lastNMoves.getFirst()[0].getValue());
        }
        return false;
    }

    protected boolean isSquare(){
        if (lastNMoves.getFirst().length > 0){
            CardValue cardValue = lastNMoves.getFirst()[0].getValue();
            Integer cpt = squareCounter.get(cardValue);
            return cpt == 4;
        }
        return false;
    }

    protected boolean noOneCanPlay(){
        int nb = 0;
        for (Card[] move : lastNMoves){
            if (nb < playersStillPlaying.size() && move.length != 0){
                return false; 
            }
            nb++;
        }
        return true;
    }

    /** winners will be used while displaying the roles */
    protected void addWinners(String playerId) {
        winners.add(playerId);
    }

    protected String getLastNMovesStr() {
        StringJoiner lastMove = new StringJoiner("#");
        for(Card[] move : lastNMoves){
            lastMove.add(Card.cardsToString(move));
        }
        return lastMove.toString();
    }

    protected void updateLastNMoves(PlayerResponse response){
        lastNMoves.addFirst(response.getCards());
        if (lastNMoves.size() > nbPlayers){
            lastNMoves.removeLast();
        }
    }   

    protected void updateSquareCounter() {
        if (lastNMoves.getFirst().length > 0){
            CardValue cardValue = lastNMoves.getFirst()[0].getValue();
            squareCounter.merge(cardValue, lastNMoves.getFirst().length, Integer::sum);
        }
    }

    public abstract void giveCardsToPlayers(Game president, Deck deck) ;

    public abstract void exchangeCards() ;

    protected void displayWinner(){
        int maxValue = 0;
        String winner = "";
        for (Map.Entry<String, Integer> entry : presidentCounter.entrySet()) {
            if (entry.getValue() > maxValue){
                maxValue = entry.getValue();
                winner = entry.getKey();
            }
        }
        System.out.printf("The winner is %s (was %d times president for the %d rounds played)%n", getPlayerName(winner), presidentCounter.get(winner), nbRounds);
    }

    public void gameOver() {
        System.out.println("End of the game");
        displayWinner();
    }

    protected void resetListAndCounter() {
        players.clear();
        players.addAll(winners);
        playersStillPlaying.clear();
        squareCounter.clear();
    }

    public abstract List<String> getPlayers();
    
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

    public int getNbRounds() {
        return this.nbRounds;
    }

    public void setNbRounds(int nbRounds) {
        this.nbRounds = nbRounds;
    }
    
    public int getNbPlayers() {
        return this.nbPlayers;
    }

    public void setNbPlayers(int nbPlayers) {
        this.nbPlayers = nbPlayers;
    }

    
}
