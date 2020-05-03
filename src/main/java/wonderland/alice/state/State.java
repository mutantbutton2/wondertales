package wonderland.alice.state;

import wonderland.alice.Game;
import wonderland.alice.component.Hand;
import wonderland.alice.component.Player;
import wonderland.alice.component.board.Board;
import wonderland.alice.component.deck.Deck;
import wonderland.alice.component.strategy.Play;
import wonderland.alice.util.Pair;

public abstract class State {

    public final Game game;
    public final State previousState;
    public final Player player;
    public final Player opponent;
    public final Board board;
    public final Deck deck;

    public State(Game game, State previousState, Player player, Player opponent, Board board, Deck deck) {
        this.game = game;
        this.previousState = previousState;
        this.player = player;
        this.opponent = opponent;
        this.board = board;
        this.deck = deck;
    }

    public abstract Pair<Player, State> play(Play play);

    public Hand currentHand() {
        return player.showHand();
    }

    public void show() {
        board.show();
    }

    public abstract Pair<Player, State> assignSeat(Player newPlayer);

    public abstract Pair<Player, State> dealCard(Player recipient);
}
