package fr.pantheonsorbonne.miage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.pantheonsorbonne.miage.enums.CardColor;
import fr.pantheonsorbonne.miage.enums.CardValue;
import fr.pantheonsorbonne.miage.game.Card;
import fr.pantheonsorbonne.miage.model.Game;
import fr.pantheonsorbonne.miage.model.GameCommand;

/**
 * this is the player part of the network version of the war game
 */
public class PresidentGameNetworkPlayer {

    static final int playerId = new Random().nextInt();
    static String playerName;
    static final List<Card> hand = new ArrayList<>();
    static final PlayerFacade playerFacade = Facade.getFacade();
    static Game president;

    public static void main(String[] args) {
        /* check if the player name is ok */
        if (args == null || args.length != 1){
            System.err.println("Usage : PresidentGameNetworkPlayer [playerName]");
            System.exit(0);
        }
        playerFacade.waitReady();
        playerName = args[0]+"-"+playerId;
        playerFacade.createNewPlayer(playerName);
        president = playerFacade.autoJoinGame("PRESIDENT");
       
        while (true) {
            GameCommand command = playerFacade.receiveGameCommand(president);
            switch (command.name()) {
                case "hasQueenOfHeart" :
                    hasQueenOfHeart();
                    break;
                case "cardsForYou":
                    handleCardsForYou(command);
                    break;
                case "plays":
                    handlePlayACard(command);
                    break;
                case "gameOver":
                    handleGameOverCommand(command);
                    break;
                default :
                    break;
            }
        }
    }

    private static void handleGameOverCommand(GameCommand command) {
    }

    private static void handlePlayACard(GameCommand command) {
    }

    private static void handleCardsForYou(GameCommand command) {
    }

    /* method that checks which player has the queen of hearts so he can start the game */
    private static void hasQueenOfHeart() {
        String result = "no";
        for (int i=0; i<hand.size()-1; i++){
            if (hand.get(i).getValue().equals(CardValue.QUEEN) && hand.get(i).getColor().equals(CardColor.HEART)){
                result = "yes";
            }
        }
        playerFacade.sendGameCommandToAll(president, new GameCommand("responseToQueenOfHeart", playerName+":"+result));
    }
}