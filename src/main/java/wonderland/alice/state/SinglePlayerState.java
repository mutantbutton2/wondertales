package wonderland.alice.state;

import wonderland.alice.Game;
import wonderland.alice.component.Player;
import wonderland.alice.component.board.Board;
import wonderland.alice.component.card.character.Character;
import wonderland.alice.component.deck.Deck;
import wonderland.alice.component.strategy.Play;
import wonderland.alice.util.Pair;

public class SinglePlayerState extends State {

    public SinglePlayerState(Game game, State previousState, Player player, Player opponent, Board board, Deck deck) {
        super(game, previousState, player, opponent, board, deck);
    }

    @Override
    public Pair<Player, State> play(Play play) {
        throw new RuntimeException("Don't know do what");
    }

    @Override
    public Pair<Player, State> assignSeat(Player newPlayer) {
        final Player acceptedPlayer = newPlayer.accept(game);;
        return new Pair<>(acceptedPlayer,  new NormalState(game, this, player, acceptedPlayer, board, deck));
    }

    @Override
    public Pair<Player, State> dealCard(Player recipient) {
        final Pair<Character, Deck> characterAndDeck = deck.pop();
        final Player newPlayer = recipient.receiveCard(characterAndDeck.left);
        // TODO: My god this if-then-else is killing me
        if (player == recipient) {
            return new Pair<>(newPlayer, new NormalState(game, this, newPlayer, opponent, board, characterAndDeck.right));
        } else {
            throw new RuntimeException("This is so hacky i am going to cry");
        }
    }
}
