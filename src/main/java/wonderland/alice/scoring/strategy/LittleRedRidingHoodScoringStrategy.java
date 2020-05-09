package wonderland.alice.scoring.strategy;

import wonderland.alice.component.card.Card;
import wonderland.alice.component.card.character.Grandma;
import wonderland.alice.component.card.character.Woodcutter;
import wonderland.alice.matcher.CardMatcher;
import wonderland.alice.scoring.Node;
import wonderland.alice.scoring.ScoringStrategy;

import static wonderland.alice.component.card.Colour.BLUE;
import static wonderland.alice.component.card.Colour.RED;
import static wonderland.alice.matcher.character.IsCharacter.isCharacter;
import static wonderland.alice.matcher.colour.IsColour.isColour;

public class LittleRedRidingHoodScoringStrategy implements ScoringStrategy {
    @Override
    public int execute(Node node) {
        int result = 0;
        if (anyGrandmaExistsAround(node))
            result += 2;
        if (anyWoodCutterExistsAround(node))
            result += 1;
        return result;
    }

    private boolean anyWoodCutterExistsAround(Node node) {
        int redWoodCutter = node.connected(new CardMatcher(isCharacter(new Woodcutter()), isColour(RED)));
        int blueWoodCutter = node.connected(new CardMatcher(isCharacter(new Woodcutter()), isColour(BLUE)));
        return redWoodCutter + blueWoodCutter > 0;
    }

    private boolean anyGrandmaExistsAround(Node node) {
        int redGrandma = node.connected(new CardMatcher(isCharacter(new Grandma()), isColour(RED)));
        int blueGrandma = node.connected(new CardMatcher(isCharacter(new Grandma()), isColour(BLUE)));
        return redGrandma + blueGrandma > 0;
    }
}
