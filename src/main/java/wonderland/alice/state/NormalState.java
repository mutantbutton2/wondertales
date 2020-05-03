package wonderland.alice.state;

import wonderland.alice.Game;
import wonderland.alice.component.deck.Deck;
import wonderland.alice.component.Player;
import wonderland.alice.component.board.Board;
import wonderland.alice.component.card.Card;
import wonderland.alice.component.card.character.Character;
import wonderland.alice.component.strategy.Play;
import wonderland.alice.util.Pair;

public class NormalState extends State {

    public NormalState(Game game, State previousState, Player player, Player opponent, Board board, Deck deck) {
        super(game, previousState, player, opponent, board, deck);
    }

    @Override
    public Pair<Player, State> play(Play play) {
        final Pair<Card, Player> cardAndRemainingHand = player.useCard(play.getCharacter());
        final int row = play.getLocation().getRow();
        final int col = play.getLocation().getCol();
        final Board newBoard = board.place(row, col, cardAndRemainingHand.left);
        final Player newPlayer = cardAndRemainingHand.right;
        return new Pair<>(newPlayer, new NormalState(game, this, opponent, newPlayer, newBoard, deck));
    }

    @Override
    public Pair<Player, State> assignSeat(Player newPlayer) {
        throw new RuntimeException("The Game is full already");
    }

    @Override
    public Pair<Player, State> dealCard(Player recipient) {
        final Pair<Character, Deck> characterAndDeck = deck.pop();
        final Player newPlayer = recipient.receiveCard(characterAndDeck.left);
        // TODO: My god this if-then-else is killing me
        if (player == recipient) {
            return new Pair<>(newPlayer, new NormalState(game, this, newPlayer, opponent, board, characterAndDeck.right));
        } else if (opponent == recipient) {
            return new Pair<>(newPlayer, new NormalState(game, this, player, newPlayer, board, characterAndDeck.right));
        } else {
            throw new RuntimeException("This is so hacky i am going to cry");
        }
    }

}
