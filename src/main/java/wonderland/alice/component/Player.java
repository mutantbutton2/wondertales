package wonderland.alice.component;

import wonderland.alice.Game;
import wonderland.alice.component.card.Card;
import wonderland.alice.component.card.Colour;
import wonderland.alice.component.card.character.Character;
import wonderland.alice.component.strategy.Play;
import wonderland.alice.component.strategy.Strategy;
import wonderland.alice.util.Pair;

public class Player {

    final Colour colour;
    final Hand hand;
    final Game game;

    public Player(Colour colour, Hand hand, Game game) {
        this.colour = colour;
        this.hand = hand;
        this.game = game;
    }

    public Player draw() {
        return game.dealCardTo(this);
    }

    public Player receiveCard(Character character) {
        final Hand newHand = hand.add(character);
        return new Player(colour, newHand, game);
    }

    public Player join(Game game) {
        return game.assignSeat(this);
    }

    public Player accept(Game game) {
        return new Player(colour, hand, game);
    }

    public Hand showHand() {
        return hand;
    }

    public Player play(Strategy strategy) {
        final Play play = strategy.execute();
        final Character character = play.getCharacter();
        final Location location = play.getLocation();

        return game.play(strategy.execute());
    }

    public Pair<Card, Player> useCard(Character character) {
        return new Pair<>(new Card(colour, character), new Player(colour, hand.use(character), game));
    }
}
