package wonderland.alice;

import wonderland.alice.component.Player;
import wonderland.alice.component.board.Board;
import wonderland.alice.component.deck.Deck;
import wonderland.alice.component.strategy.Play;
import wonderland.alice.state.NoPlayerState;
import wonderland.alice.state.State;
import wonderland.alice.util.Pair;

public class Game {

    State currentState;

    public Game(Deck deck) {
        this.currentState = new NoPlayerState(this, null, Board.createEmptyBoard(), deck);
    }

    public Player assignSeat(Player player) {
        final Pair<Player, State> playerAndCurrentState = currentState.assignSeat(player);
        this.currentState = playerAndCurrentState.right;
        // TODO: return something different if a player cannot join a game for any reason
        return playerAndCurrentState.left;
    }

    public Player play(Play play) {
        final Pair<Player, State> playerAndCurrentState = currentState.play(play);
        currentState = playerAndCurrentState.right;
        return playerAndCurrentState.left;
    }

    public void show() {
        currentState.show();
    }

    public boolean isEnded() {
        return currentState.board.isFull();
    }

    public Player dealCardTo(Player player) {
        Pair<Player, State> playerAndCurrentState = currentState.dealCard(player);
        this.currentState = playerAndCurrentState.right;
        return playerAndCurrentState.left;
    }


}
