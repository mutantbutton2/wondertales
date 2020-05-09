package wonderland.alice.scoring.strategy;

import wonderland.alice.matcher.CardMatcher;
import wonderland.alice.scoring.Node;
import wonderland.alice.scoring.ScoringStrategy;

import static wonderland.alice.matcher.character.AnyCharacter.anyCharacter;
import static wonderland.alice.matcher.colour.IsColour.isColour;

public class PapaBearScoringStrategy implements ScoringStrategy {

    @Override
    public int execute(Node node) {
        return node.connected(new CardMatcher(anyCharacter(), isColour(node.card.colour)));
    }
}
