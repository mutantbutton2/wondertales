package wonderland.alice.scoring.strategy;

import org.junit.Test;
import wonderland.alice.component.card.Card;
import wonderland.alice.component.card.character.BigBadWolf;
import wonderland.alice.component.card.character.LittlePigTwo;
import wonderland.alice.component.card.character.Woodcutter;
import wonderland.alice.scoring.Node;
import wonderland.alice.scoring.ScoringStrategy;

import static org.junit.Assert.assertEquals;
import static wonderland.alice.component.card.Colour.RED;

public class LittlePigTwoScoringStrategyTest extends ScoringStrategyTest {

    private final Node littlePigTwo = new Node(new Card(RED, new LittlePigTwo()));
    private final ScoringStrategy scoringStrategy = new LittlePigTwoScoringStrategy();

    @Test
    public void IfWoodcutterIsAroundShouldReturnOnePoint() {
        littlePigTwo.setRight(blue(new Woodcutter()), 1);
        assertEquals(1, scoringStrategy.execute(littlePigTwo));
    }

    @Test
    public void IfBigBadWolfIsAroundShouldDeductFivePoints() {
        littlePigTwo.setRight(blue(new BigBadWolf()), 1);
        assertEquals(-5, scoringStrategy.execute(littlePigTwo));
    }

    @Test
    public void testCombination() {
        littlePigTwo.setRight(blue(new Woodcutter()), 1);
        littlePigTwo.setBottom(blue(new BigBadWolf()), 1);
        assertEquals(-4, scoringStrategy.execute(littlePigTwo));
    }
}
