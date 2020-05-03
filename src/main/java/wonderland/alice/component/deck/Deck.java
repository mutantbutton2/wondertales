package wonderland.alice.component.deck;

import wonderland.alice.component.card.character.Character;
import wonderland.alice.util.Pair;

public interface Deck {
    Pair<Character, Deck> pop();
}
