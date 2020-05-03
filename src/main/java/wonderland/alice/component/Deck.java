package wonderland.alice.component;

import wonderland.alice.component.card.character.*;
import wonderland.alice.component.card.character.Character;
import wonderland.alice.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Deck {

    private final List<Character> characters;

    public Deck(List<Character> characters) {
        this.characters = characters;
    }

    public Pair<Character, Deck> pop() {
        return new Pair<>(characters.get(0), new Deck(characters.subList(1, characters.size())));
    }

    public static Deck createDeck() {
        final List<Character> characterStack = new ArrayList<>();
        characterStack.add(new BabyBear());
        characterStack.add(new BigBadWolf());
        characterStack.add(new FrogPrince());
        characterStack.add(new Goldilocks());
        characterStack.add(new Grandma());
        characterStack.add(new Gretel());
        characterStack.add(new Hansel());
        characterStack.add(new LittlePig());
        characterStack.add(new LittlePig());
        characterStack.add(new LittlePig());
        characterStack.add(new LittleRedRidingHood());
        characterStack.add(new MamaBear());
        characterStack.add(new PapaBear());
        characterStack.add(new Princess());
        characterStack.add(new Stepmother());
        characterStack.add(new Witch());
        characterStack.add(new Woodcutter());
        return new Deck(characterStack);
    }
}
