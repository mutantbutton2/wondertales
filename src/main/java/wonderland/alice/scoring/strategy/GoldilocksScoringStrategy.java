package wonderland.alice.scoring.strategy;

import wonderland.alice.component.card.character.*;
import wonderland.alice.matcher.CardMatcher;
import wonderland.alice.scoring.Node;
import wonderland.alice.scoring.ScoringStrategy;

import static wonderland.alice.matcher.character.IsCharacter.isCharacter;
import static wonderland.alice.matcher.colour.AnyColour.anyColour;

public class GoldilocksScoringStrategy implements ScoringStrategy {

    @Override
    public int execute(Node node) {
        return anyBearAround(node) ? 0 : 5;
    }

    private boolean anyBearAround(Node node) {
        return node.connected(new CardMatcher(isCharacter(new PapaBear()), anyColour()))
                + node.connected(new CardMatcher(isCharacter(new MamaBear()), anyColour()))
                + node.connected(new CardMatcher(isCharacter(new BabyBear()), anyColour()))
                > 0;
    }
}
