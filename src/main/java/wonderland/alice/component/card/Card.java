package wonderland.alice.component.card;

import wonderland.alice.component.card.character.Character;
import wonderland.alice.util.AsciiColour;

public class Card {

    private final Colour colour;
    private final Character character;

    public Card(Colour colour, Character character) {
        this.colour = colour;
        this.character = character;
    }

    @Override
    public String toString() {
        return colour.wrapText(String.format("%-20s",character.toString()));
    }
}
