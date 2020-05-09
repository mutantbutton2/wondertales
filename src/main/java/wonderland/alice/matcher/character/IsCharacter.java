package wonderland.alice.matcher.character;

import wonderland.alice.component.card.character.Character;

public class IsCharacter implements CharacterMatcher {

    private final Character character;

    public static IsCharacter isCharacter(Character character) {
        return new IsCharacter(character);
    }

    public IsCharacter(Character character) {
        this.character = character;
    }

    @Override
    public boolean match(Character character) {
        return this.character.equals(character);
    }
}
