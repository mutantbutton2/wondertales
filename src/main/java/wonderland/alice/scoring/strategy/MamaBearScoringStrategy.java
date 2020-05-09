package wonderland.alice.scoring.strategy;

import wonderland.alice.component.card.Colour;
import wonderland.alice.matcher.CardMatcher;
import wonderland.alice.scoring.Node;
import wonderland.alice.scoring.ScoringStrategy;

import static wonderland.alice.matcher.character.AnyCharacter.anyCharacter;
import static wonderland.alice.matcher.colour.IsColour.isColour;

public class MamaBearScoringStrategy implements ScoringStrategy {

    @Override
    public int execute(Node node) {
        return node.connected(new CardMatcher(anyCharacter(), isColour(opposingColour(node.card.colour))));
    }

    private Colour opposingColour(Colour colour) {
        return colour == Colour.BLUE ? Colour.RED : Colour.BLUE;
    }
}
