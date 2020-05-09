package wonderland.alice.matcher.character;

import wonderland.alice.component.card.character.Character;

import java.util.Set;

public class OneOfCharacters implements CharacterMatcher {

    public static OneOfCharacters oneOf(Set<Character> characterSet) {
        return new OneOfCharacters(characterSet);
    }

    private final Set<Character> characters;

    private OneOfCharacters(Set<Character> characters) {
        this.characters = characters;
    }

    @Override
    public boolean match(Character character) {
        return characters.contains(character);
    }
}
