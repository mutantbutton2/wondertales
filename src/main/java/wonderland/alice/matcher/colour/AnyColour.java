package wonderland.alice.matcher.colour;

import wonderland.alice.component.card.Colour;

public class AnyColour implements ColourMatcher {

    private static final AnyColour instance = new AnyColour();

    public static final AnyColour anyColour() {
        return instance;
    }

    private AnyColour() {
    }

    @Override
    public boolean match(Colour colour) {
        return colour != Colour.BLANK;
    }
}
