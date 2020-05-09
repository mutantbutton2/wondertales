package wonderland.alice.scoring.strategy;

import wonderland.alice.component.card.character.BigBadWolf;
import wonderland.alice.component.card.character.LittleRedRidingHood;
import wonderland.alice.component.card.character.Woodcutter;
import wonderland.alice.matcher.CardMatcher;
import wonderland.alice.scoring.Node;
import wonderland.alice.scoring.ScoringStrategy;

import static wonderland.alice.matcher.character.IsCharacter.isCharacter;
import static wonderland.alice.matcher.colour.AnyColour.anyColour;

public class LittlePigTwoScoringStrategy implements ScoringStrategy {

    @Override
    public int execute(Node node) {
        int result = 0;
        if (isWoodcutterAround(node))
            result += 1;
        if (isBigBadWolfAround(node))
            result -= 5;
        return result;
    }

    private boolean isWoodcutterAround(Node node) {
        int woodcutter = node.connected(new CardMatcher(isCharacter(new Woodcutter()), anyColour()));
        return woodcutter > 0;
    }

    private boolean isBigBadWolfAround(Node node) {
        int bigBadWolf = node.connected(new CardMatcher(isCharacter(new BigBadWolf()), anyColour()));
        return bigBadWolf > 0;
    }
}
