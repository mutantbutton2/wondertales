package wonderland.alice.scoring.strategy;

import wonderland.alice.component.card.character.Hansel;
import wonderland.alice.component.card.character.Stepmother;
import wonderland.alice.component.card.character.Witch;
import wonderland.alice.matcher.CardMatcher;
import wonderland.alice.scoring.Node;
import wonderland.alice.scoring.ScoringStrategy;

import static wonderland.alice.matcher.character.IsCharacter.isCharacter;
import static wonderland.alice.matcher.colour.AnyColour.anyColour;

public class GretelScoringStrategy implements ScoringStrategy {

    @Override
    public int execute(Node node) {
        int result = 0;
        if (isGretelAround(node))
            result += 3;
        if (isStepmotherAround(node))
            result -= 2;
        if (isWitchAround(node))
            result -= 4;
        return result;
    }

    private boolean isGretelAround(Node node) {
        int gretel = node.connected(new CardMatcher(isCharacter(new Hansel()), anyColour()));
        return gretel > 0;
    }

    private boolean isStepmotherAround(Node node) {
        int stepmother = node.connected(new CardMatcher(isCharacter(new Stepmother()), anyColour()));
        return stepmother > 0;
    }

    private boolean isWitchAround(Node node) {
        int witch = node.connected(new CardMatcher(isCharacter(new Witch()), anyColour()));
        return witch > 0;
    }
}
