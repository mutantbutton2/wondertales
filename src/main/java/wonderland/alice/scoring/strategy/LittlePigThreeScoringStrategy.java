package wonderland.alice.scoring.strategy;

import wonderland.alice.component.card.character.BigBadWolf;
import wonderland.alice.component.card.character.Woodcutter;
import wonderland.alice.matcher.CardMatcher;
import wonderland.alice.scoring.Node;
import wonderland.alice.scoring.ScoringStrategy;

import static wonderland.alice.matcher.character.IsCharacter.isCharacter;
import static wonderland.alice.matcher.colour.AnyColour.anyColour;

public class LittlePigThreeScoringStrategy implements ScoringStrategy {

    @Override
    public int execute(Node node) {
        return isBigBadWolfAround(node) ? -5 : 0;
    }
    private boolean isBigBadWolfAround(Node node) {
        int bigBadWolf = node.connected(new CardMatcher(isCharacter(new BigBadWolf()), anyColour()));
        return bigBadWolf > 0;
    }
}
