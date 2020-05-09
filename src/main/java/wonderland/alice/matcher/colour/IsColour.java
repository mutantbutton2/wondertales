package wonderland.alice.matcher.colour;

import wonderland.alice.component.card.Colour;

public class IsColour implements ColourMatcher  {

    private final Colour colour;

    public static IsColour isColour(Colour colour) {
        return new IsColour(colour);
    }

    public IsColour(Colour colour) {
        this.colour = colour;
    }

    @Override
    public boolean match(Colour colour) {
        return this.colour.equals(colour);
    }
}
