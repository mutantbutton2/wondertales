package wonderland.alice.scoring.strategy;

import wonderland.alice.component.card.character.*;
import wonderland.alice.matcher.CardMatcher;
import wonderland.alice.scoring.Node;
import wonderland.alice.scoring.ScoringStrategy;

import static wonderland.alice.matcher.character.IsCharacter.isCharacter;
import static wonderland.alice.matcher.colour.AnyColour.anyColour;

public class WoodcutterScoringStrategy implements ScoringStrategy {

    @Override
    public int execute(Node node) {
        int result = 0;
        if (isHanselAround(node))
            result += 2;
        if (isGretelAround(node))
            result += 2;
        if (isStepmotherAround(node))
            result += 1;
        return result;
    }

    private boolean isHanselAround(Node node) {
        int hansel = node.connected(new CardMatcher(isCharacter(new Hansel()), anyColour()));
        return hansel > 0;
    }

    private boolean isGretelAround(Node node) {
        int gretel = node.connected(new CardMatcher(isCharacter(new Gretel()), anyColour()));
        return gretel > 0;
    }

    private boolean isStepmotherAround(Node node) {
        int stepmother = node.connected(new CardMatcher(isCharacter(new Stepmother()), anyColour()));
        return stepmother > 0;
    }
}
