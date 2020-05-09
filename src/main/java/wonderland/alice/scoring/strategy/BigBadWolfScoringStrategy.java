package wonderland.alice.scoring.strategy;

import wonderland.alice.component.card.character.LittlePigOne;
import wonderland.alice.component.card.character.LittleRedRidingHood;
import wonderland.alice.component.card.character.Woodcutter;
import wonderland.alice.matcher.CardMatcher;
import wonderland.alice.scoring.Node;
import wonderland.alice.scoring.ScoringStrategy;

import static wonderland.alice.matcher.character.IsCharacter.isCharacter;
import static wonderland.alice.matcher.colour.AnyColour.anyColour;

public class BigBadWolfScoringStrategy implements ScoringStrategy {

    @Override
    public int execute(Node node) {
        int result = numberOfConnectedLittlePigs(node);
        if (anyLittleRedRidingHoodAround(node))
            result += 2;
        if (anyWoodcutterAround(node))
            result -= 5;
        return result;
    }

    private boolean anyLittleRedRidingHoodAround(Node node) {
        int littleRedRidingHood = node.connected(new CardMatcher(isCharacter(new LittleRedRidingHood()), anyColour()));
        return littleRedRidingHood > 0;
    }

    private boolean anyWoodcutterAround(Node node) {
        int woodCutter = node.connected(new CardMatcher(isCharacter(new Woodcutter()), anyColour()));
        return woodCutter > 0;
    }

    private int numberOfConnectedLittlePigs(Node node) {
        return node.connected(new CardMatcher(isCharacter(new LittlePigOne()), anyColour()));
    }
}
