package wonderland.alice.matcher.character;

import wonderland.alice.component.card.character.Character;
import wonderland.alice.component.card.character.Empty;

public class AnyCharacter implements CharacterMatcher {

    private static final AnyCharacter instance = new AnyCharacter();

    public static AnyCharacter anyCharacter() {
        return instance;
    }

    private AnyCharacter() {
    }

    @Override
    public boolean match(Character character) {
        return !character.equals(new Empty());
    }
}
