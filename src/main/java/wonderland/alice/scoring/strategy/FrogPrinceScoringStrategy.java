package wonderland.alice.scoring.strategy;

import wonderland.alice.component.card.character.Gretel;
import wonderland.alice.component.card.character.Princess;
import wonderland.alice.component.card.character.Stepmother;
import wonderland.alice.component.card.character.Witch;
import wonderland.alice.matcher.CardMatcher;
import wonderland.alice.scoring.Node;
import wonderland.alice.scoring.ScoringStrategy;

import static wonderland.alice.matcher.character.IsCharacter.isCharacter;
import static wonderland.alice.matcher.colour.AnyColour.anyColour;

public class FrogPrinceScoringStrategy implements ScoringStrategy {

    @Override
    public int execute(Node node) {
        int result = 0;
        if (isPrincessAround(node))
            result += 3;
        if (isWitchAround(node))
            result -= 2;
        return result;
    }

    private boolean isPrincessAround(Node node) {
        int princess = node.connected(new CardMatcher(isCharacter(new Princess()), anyColour()));
        return princess > 0;
    }

    private boolean isWitchAround(Node node) {
        int gretel = node.connected(new CardMatcher(isCharacter(new Witch()), anyColour()));
        return gretel > 0;
    }
}
