import java.util.*;
import fr.pantheonsorbonne.miage.model.Game;
/**
 * This class implements the war game with the network engine
 */
public class PresidentGameNetworkEngine extends PresidentGameEngine {
    /*the game take 4 players whenever it is played in netword  */
    private static final int PLAYER_COUNT = 4;
    private final HostFacade hostFacade;
    private final Game president;
    /* answer to hasQueenOfHearts */
    private final boolean answer;
    /* getting the playerName when he joins the game */
    private final String playerName;
    /*storing the players name in a list 
     * wil be use when roles will be displayed 
     */
    private final List<String> players=new LinkedList<>();
    /* winners needs to be a LinkedHashSet so we can keep the seizure order
     * this will help when roles will be displayed 
     */
    private final  Set<String> winners=new LinkedHashSet<>();
    /*
     * playersStillPlaying keeps the players name and the play order 
     */
    private final Set<String> playersStillPlaying=new LinkedHashSet<>();

    public PresidentGameNetworkEngine(HostFacade hostFacade, List<String> players, fr.pantheonsorbonne.miage.model.Game president) {
        this.hostFacade = hostFacade;
        this.players = players;
        this.president = president;
    }
    public static void main(String[] args) {
        //create the host facade
        HostFacade hostFacade = Facade.getFacade();
        hostFacade.waitReady();

        //set the name of the player
        hostFacade.createNewPlayer("Host");
    //create a new game of president
fr.pantheonsorbonne.miage.model.Game president = hostFacade.createNewGame("PRESIDENT");

//wait for enough players to join
hostFacade.waitForExtraPlayerCount(PLAYER_COUNT);

PresidentGameEngine host = new PresidentGameNetworkEngine(hostFacade, president.getPlayers(), president);
host.play();
    } 

/* parent method should be implement in PresidentGameEngine (check teacher's example)  */
@Override
protected Set<String> getNamePlayers() {
    return this.president.getPlayers();
    }

/*
 * 
 * @param playerName name of the player to receive the cards/ first play 
 */
@Override
protected void giveCardsToPlayer(String playerName, String hand) {
        hostFacade.sendGameCommandToPlayer(president, playerName, new GameCommand("cardsForYou", hand));
    }

/* method that checks which player has the queen of hearts so he can start the game */
protected void hasQueenOfHearts(boolean answer){
    this.answer=answer ;
}
/* storing the name of the first player  */
protected void firstPlayer(String playerName){
    this.playerName = playerName;
}

/* the host designates who's the next player and sends him the cards played  */
protected void plays(Card[] cards){
System.out.println("it's your turn ! Here the cards palyed before :"+cards.toSring());
}

/* not sure about this method -> should be written in a Card class */
@Override
protected void cards (Card[] cards , int nbCards){
    this.cards = cards; 
    this.nbCards=nbCards;
}

/* winners will be used while displaying the roles  */
protected void addWinners( Set <String> winners){
    winners.add(playerName);
}
/* telling which players still in the game -> will help saying that the sleeve 
 * is over when there's one player left 
 */
private void playersInTheGame (Set<String> playersStillPlaying){
    System.out.println("players still playing "+playersStillPlaying.toString());
    }
/* reset the card set if a sleeve is over */
@Override
protected void reset(Card[] cards){
    for (int i=0; i<cards.length; i++){
        cards[i]=null;
    }
}

/* displaying the roles and initiating the cards exchange  */
protected void displayRoles(String[] winners,int nbCards, String type, int position ){
System.out.println(winners[position]+" has to give his/her "+type+"cards to "+winners[winners.length-position]);
}


}