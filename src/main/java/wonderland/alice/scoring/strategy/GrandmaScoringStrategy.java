package wonderland.alice.scoring.strategy;

import wonderland.alice.component.card.character.*;
import wonderland.alice.matcher.CardMatcher;
import wonderland.alice.scoring.Node;
import wonderland.alice.scoring.ScoringStrategy;

import static wonderland.alice.matcher.character.IsCharacter.isCharacter;
import static wonderland.alice.matcher.colour.AnyColour.anyColour;

public class GrandmaScoringStrategy implements ScoringStrategy {

    @Override
    public int execute(Node node) {
        int result = 0;
        if (isLittleRedRidingHood(node))
            result += 3;
        if (isBigBadWolfAround(node))
            result -= 2;
        return result;
    }

    private boolean isLittleRedRidingHood(Node node) {
        int gretel = node.connected(new CardMatcher(isCharacter(new LittleRedRidingHood()), anyColour()));
        return gretel > 0;
    }

    private boolean isBigBadWolfAround(Node node) {
        int stepmother = node.connected(new CardMatcher(isCharacter(new BigBadWolf()), anyColour()));
        return stepmother > 0;
    }
}
