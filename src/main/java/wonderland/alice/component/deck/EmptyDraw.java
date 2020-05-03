package wonderland.alice.component.deck;

import wonderland.alice.component.card.character.Character;
import wonderland.alice.component.card.character.Empty;
import wonderland.alice.util.Pair;

class EmptyDraw implements Deck {

    private static final EmptyDraw emptyDraw = new EmptyDraw();

    static EmptyDraw empty() {
        return emptyDraw;
    }

    @Override
    public Pair<Character, Deck> pop() {
        return new Pair<>(new Empty(), empty());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return EmptyDraw.class.equals(obj.getClass());
    }
}
