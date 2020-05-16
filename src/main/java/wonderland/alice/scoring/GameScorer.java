package wonderland.alice.scoring;

import wonderland.alice.component.card.Colour;
import wonderland.alice.util.Pair;

public class GameScorer {

    private final CardStrategyVisitor cardStrategyVisitor = new CardStrategyVisitor();

    public Pair<Integer, Integer> calculate(Slot[][] slots) {
        int redPoints = 0;
        int bluePoints = 0;
        for (int row = 0; row < slots.length-1; row++) {
            for (int column = 0; column < slots[0].length-1; column++) {
                final Slot slot = slots[row][column];
                final ScoringStrategy scoringStrategy = slot.cardNode.card.character.accept(cardStrategyVisitor);
                final int points = scoringStrategy.execute(slot.cardNode);
                if (slot.cardNode.card.colour == Colour.RED) redPoints += points;
                if (slot.cardNode.card.colour == Colour.BLUE) bluePoints += points;
            }
        }
        return new Pair<>(redPoints, bluePoints);
    }
}
