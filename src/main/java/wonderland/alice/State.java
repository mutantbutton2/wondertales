package wonderland.alice;

import wonderland.alice.component.Deck;
import wonderland.alice.component.Hand;
import wonderland.alice.component.Player;
import wonderland.alice.component.board.Board;
import wonderland.alice.component.card.Card;
import wonderland.alice.component.card.character.Character;
import wonderland.alice.component.strategy.Play;
import wonderland.alice.util.Pair;

public class State {

    final Game game;
    final State previousState;
    final Player player;
    final Player opponent;
    final Board board;
    final Deck deck;

    public State(State previousState, Game game, Player player, Player opponent, Board board, Deck deck) {
        this.previousState = previousState;
        this.game = game;
        this.player = player;
        this.opponent = opponent;
        this.board = board;
        this.deck = deck;
    }

    public Pair<Player, State> play(Play play) {
        final Pair<Card, Player> cardAndRemainingHand = player.useCard(play.getCharacter());
        final int row = play.getLocation().getRow();
        final int col = play.getLocation().getCol();
        final Board newBoard = board.place(row, col, cardAndRemainingHand.left);
        final Player newPlayer = cardAndRemainingHand.right;
        return new Pair<>(newPlayer, new State(this, game, opponent, newPlayer, newBoard, deck));
    }

    // TODO; this feels hacky as well
    public Board getBoard() {
        return board;
    }

    public Hand currentHand() {
        return player.showHand();
    }

    public void show() {
        board.show();
    }

    public Pair<Player, State> assignSeat(Player newPlayer) {
        final Player acceptedPlayer = newPlayer.accept(game);
        if (this.player == null) {
            return new Pair<>(acceptedPlayer, new State(previousState, game, acceptedPlayer, opponent, board, deck));
        } else if (this.opponent == null) {
            return new Pair<>(acceptedPlayer, new State(previousState, game, player, acceptedPlayer, board, deck));
        } else {
            throw new RuntimeException("This is so ugly we need to fix this");
        }
    }

    public Pair<Player, State> dealCard(Player recipient) {
        final Pair<Character, Deck> characterAndDeck = deck.pop();
        final Player newPlayer = recipient.receiveCard(characterAndDeck.left);
        // TODO: My god this if-then-else is killing me
        if (player == recipient) {
            return new Pair<>(newPlayer, new State(this, game, newPlayer, opponent, board, characterAndDeck.right));
        } else if (opponent == recipient) {
            return new Pair<>(newPlayer, new State(this, game, player, newPlayer, board, characterAndDeck.right));
        } else {
            throw new RuntimeException("This is so hacky i am going to cry");
        }
    }

}
