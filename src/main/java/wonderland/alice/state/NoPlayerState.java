package wonderland.alice.state;

import wonderland.alice.Game;
import wonderland.alice.component.Player;
import wonderland.alice.component.board.Board;
import wonderland.alice.component.deck.Deck;
import wonderland.alice.component.strategy.Play;
import wonderland.alice.util.Pair;

public class NoPlayerState extends State {

    public NoPlayerState(Game game, State previousState, Board board, Deck deck) {
        super(game, previousState, null, null, board, deck);
    }

    @Override
    public Pair<Player, State> play(Play play) {
        throw new RuntimeException("Ehhhhh havn't got an idea what to do yet");
    }

    @Override
    public Pair<Player, State> assignSeat(Player newPlayer) {
        final Player acceptedPlayer = newPlayer.accept(game);;
        return new Pair<>(acceptedPlayer,  new SinglePlayerState(game, this, acceptedPlayer, opponent, board, deck));
    }

    @Override
    public Pair<Player, State> dealCard(Player recipient) {
        throw new RuntimeException("Ehhhhh havn't got an idea what to do yet");
    }
}
