package wonderland.alice;


import org.junit.Test;
import wonderland.alice.component.deck.Deck;
import wonderland.alice.component.Hand;
import wonderland.alice.component.Player;
import wonderland.alice.component.card.character.BabyBear;
import wonderland.alice.component.card.character.BigBadWolf;
import wonderland.alice.component.deck.DeckBuilder;
import wonderland.alice.component.deck.Draw;
import wonderland.alice.component.strategy.FirstCardStrategy;
import wonderland.alice.scoring.BoardNodeConverter;
import wonderland.alice.scoring.GameScorer;
import wonderland.alice.scoring.Slot;
import wonderland.alice.util.Pair;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static wonderland.alice.component.card.Colour.BLUE;
import static wonderland.alice.component.card.Colour.RED;

public class GameTest {

    private final Player firstPlayer = new Player(RED, Hand.emptyHand(), null);
    private final Player secondPlayer = new Player(BLUE, Hand.emptyHand(), null);

    @Test
    public void assignPlayer1() {
        final Deck deck = Draw.createDeck();
        Player player1 = firstPlayer;

        Game game = new Game(deck);
        player1 = player1.join(game);
        assertTrue(game.currentState.player == player1);
    }

    @Test
    public void assignTwoPlayers() {
        final Deck deck = Draw.createDeck();
        Player player1 = firstPlayer;
        Player player2 = secondPlayer;

        Game game = new Game(deck);
        player1 = player1.join(game);
        player2 = player2.join(game);
        assertTrue(game.currentState.opponent == player2);
    }

    @Test
    public void assignSingleCardToFirstPlayer() {
        final Deck deck = new DeckBuilder().addCard(new BabyBear()).build();
        Player player1 = firstPlayer;
        Player player2 = secondPlayer;

        Game game = new Game(deck);
        player1 = player1.join(game);

        player1 = player1.draw();
        assertTrue(new Hand(List.of(new BabyBear())).equals(player1.showHand()));

    }

    @Test
    public void assignMultipleCardToFirstPlayer() {
        final Deck deck = new DeckBuilder().addCard(new BabyBear()).addCard(new BigBadWolf()).build();
        Player player1 = firstPlayer;

        Game game = new Game(deck);
        player1 = player1.join(game);

        player1 = player1.draw();
        player1 = player1.draw();
        assertEquals(new Hand(List.of(new BabyBear(), new BigBadWolf())), player1.showHand());

    }

    @Test
    public void assignOneCardToEachPlayer() {
        final Deck deck = new DeckBuilder().addCard(new BabyBear()).addCard(new BigBadWolf()).build();
        Player player1 = firstPlayer;
        Player player2 = secondPlayer;

        Game game = new Game(deck);
        player1 = player1.join(game);
        player2 = player2.join(game);

        player1 = player1.draw();
        player2 = player2.draw();
        assertEquals(new Hand(List.of(new BigBadWolf())), player1.showHand());
        assertEquals(new Hand(List.of(new BabyBear())), player2.showHand());
    }

    @Test
    public void test() {

        final Deck deck = Draw.createDeck();
        Player player1 = firstPlayer;
        Player player2 = secondPlayer;

        Game game = new Game(deck);
        player1 = player1.join(game);
        player2 = player2.join(game);

        player1 = player1.draw();
        player2 = player2.draw();
        player1 = player1.draw();
        player2 = player2.draw();

        for (int i = 0; i < 7; i++) {
            player1 = player1.play(new FirstCardStrategy(game.currentState));
            player1 = player1.draw();
            player2 = player2.play(new FirstCardStrategy(game.currentState));
            player2 = player2.draw();

        }

        player1 = player1.play(new FirstCardStrategy(game.currentState));

        game.show();

        final Slot[][] slots = new BoardNodeConverter(game.currentState.board.board).convert();
        Pair<Integer, Integer> result = new GameScorer().calculate(slots);
        System.out.println("Red: " + result.left);
        System.out.println("Blue: " + result.right);

    }
}

