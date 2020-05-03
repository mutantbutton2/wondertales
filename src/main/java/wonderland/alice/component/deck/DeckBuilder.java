package wonderland.alice.component.deck;

import static wonderland.alice.component.deck.EmptyDraw.empty;
import wonderland.alice.component.card.character.Character;

public class DeckBuilder {

    private final Deck deck;

    public DeckBuilder() {
        this(empty());
    }

    private DeckBuilder(Deck deck) {
        this.deck = deck;
    }

    public DeckBuilder addCard(Character character) {
        return new DeckBuilder(new Draw(character, deck));
    }

    public Deck build() {
        return deck;
    }
}
