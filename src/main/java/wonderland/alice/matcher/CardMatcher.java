package wonderland.alice.matcher;

import wonderland.alice.component.card.Card;
import wonderland.alice.matcher.character.CharacterMatcher;
import wonderland.alice.matcher.colour.ColourMatcher;

public class CardMatcher {

    private final CharacterMatcher characterMatcher;
    private final ColourMatcher colourMatcher;

    public CardMatcher(CharacterMatcher characterMatcher, ColourMatcher colourMatcher) {
        this.characterMatcher = characterMatcher;
        this.colourMatcher = colourMatcher;
    }

    public boolean match(Card card) {
        return characterMatcher.match(card.character) && colourMatcher.match(card.colour);
    }
}
