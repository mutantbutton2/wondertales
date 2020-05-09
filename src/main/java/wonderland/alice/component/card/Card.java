package wonderland.alice.component.card;

import wonderland.alice.component.card.character.Character;
import wonderland.alice.component.card.character.Empty;
import wonderland.alice.matcher.CardMatcher;

import java.util.Objects;

import static wonderland.alice.component.card.Colour.BLANK;

public class Card {

    public final Colour colour;
    public final Character character;

    public static Card emptyCard() {
        return new Card(BLANK, new Empty());
    }

    public Card(Colour colour, Character character) {
        this.colour = colour;
        this.character = character;
    }

    @Override
    public String toString() {
        return colour.wrapText(String.format("%-20s",character.toString()));
    }

    public boolean match(CardMatcher cardMatcher) {
        return cardMatcher.match(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return colour == card.colour &&
                Objects.equals(character, card.character);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colour, character);
    }
}
