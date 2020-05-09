package wonderland.alice.scoring.strategy;

import org.junit.Test;
import wonderland.alice.component.card.Card;
import wonderland.alice.component.card.character.*;
import wonderland.alice.scoring.Node;
import wonderland.alice.scoring.ScoringStrategy;

import static org.junit.Assert.assertEquals;
import static wonderland.alice.component.card.Colour.RED;

public class GrandmaScoringStrategyTest extends ScoringStrategyTest {

    private final Node grandma = new Node(new Card(RED, new Grandma()));
    private final ScoringStrategy scoringStrategy = new GrandmaScoringStrategy();

    @Test
    public void IfLittleRedRidingHoodIsAroundShouldReturnThreePoints() {
        grandma.setRight(blue(new LittleRedRidingHood()), 1);
        assertEquals(3, scoringStrategy.execute(grandma));
    }

    @Test
    public void IfBigBadWolfIsAroundShouldDeductTwoPoints() {
        grandma.setRight(blue(new BigBadWolf()), 1);
        assertEquals(-2, scoringStrategy.execute(grandma));
    }
    @Test
    public void testCombination() {
        grandma.setRight(blue(new LittleRedRidingHood()), 1);
        grandma.setBottom(blue(new BigBadWolf()), 1);
        assertEquals(1, scoringStrategy.execute(grandma));
    }
}
