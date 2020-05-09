package wonderland.alice.scoring.strategy;

import wonderland.alice.component.card.Card;
import wonderland.alice.component.card.character.Character;
import wonderland.alice.scoring.Node;

import static wonderland.alice.component.card.Colour.BLUE;
import static wonderland.alice.component.card.Colour.RED;

public abstract class ScoringStrategyTest {

    Node red(Character character) {
        return new Node(new Card(RED, character));
    }

    Node blue(Character character) {
        return new Node(new Card(BLUE, character));
    }

}
