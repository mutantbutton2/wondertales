package wonderland.alice.component.strategy;

import wonderland.alice.component.Location;
import wonderland.alice.component.card.character.Character;

public class Play {

    private final Character character;
    private final Location location;

    public Play(Character character, Location location) {
        this.character = character;
        this.location = location;
    }

    public Character getCharacter() {
        return character;
    }

    public Location getLocation() {
        return location;
    }
}
