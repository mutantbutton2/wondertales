package wonderland.alice.component.card;

import wonderland.alice.util.AsciiColour;

public enum Colour {

    BLUE(AsciiColour.ANSI_BLUE),
    RED(AsciiColour.ANSI_RED),
    BLANK(AsciiColour.ANSI_WHITE);

    private final String asciiColour;

    Colour(String asciiColour) {
        this.asciiColour = asciiColour;
    }

    public String wrapText(String text) {
        return asciiColour + text + AsciiColour.ANSI_RESET;
    }
}
