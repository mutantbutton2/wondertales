package wonderland.alice.scoring.strategy;

import org.junit.Test;
import wonderland.alice.component.card.Card;
import wonderland.alice.component.card.character.*;
import wonderland.alice.scoring.Node;
import wonderland.alice.scoring.ScoringStrategy;

import static org.junit.Assert.assertEquals;
import static wonderland.alice.component.card.Colour.RED;

public class BigBadWolfScoringStrategyTest extends ScoringStrategyTest {

    private final Node redBigBadWolf = new Node(new Card(RED, new BigBadWolf()));
    private final ScoringStrategy scoringStrategy = new BigBadWolfScoringStrategy();

    @Test
    public void ifLittleRidingHoodAroundShouldReturnOnePoint() {
        redBigBadWolf.setLeft(blue(new LittleRedRidingHood()), 1);
        assertEquals(2, scoringStrategy.execute(redBigBadWolf));
    }

    @Test
    public void OnePointForEachConnectedLittlePig() {
        redBigBadWolf.setLeft(blue(new LittlePigOne()), 1);
        redBigBadWolf.setRight(blue(new LittlePigOne()), 1);
        redBigBadWolf.setTop(blue(new LittlePigOne()), 1);
        assertEquals(3, scoringStrategy.execute(redBigBadWolf));
    }

    @Test
    public void MinusFivePointsIfConnectedToWoodCutter() {
        redBigBadWolf.setLeft(blue(new Woodcutter()), 1);
        assertEquals(-5, scoringStrategy.execute(redBigBadWolf));
    }

    @Test
    public void SomeCombination() {
        redBigBadWolf.setTop(blue(new LittleRedRidingHood()), 1);
        redBigBadWolf.setLeft(blue(new LittlePigOne()), 1);
        redBigBadWolf.setRight(blue(new LittlePigOne()), 1);
        redBigBadWolf.setBottom(blue(new Woodcutter()), 1);
        assertEquals(-1, scoringStrategy.execute(redBigBadWolf));
    }
}
