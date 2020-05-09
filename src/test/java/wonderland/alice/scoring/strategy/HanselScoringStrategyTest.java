package wonderland.alice.scoring.strategy;

import org.junit.Test;
import wonderland.alice.component.card.Card;
import wonderland.alice.component.card.character.*;
import wonderland.alice.scoring.Node;
import wonderland.alice.scoring.ScoringStrategy;

import static org.junit.Assert.assertEquals;
import static wonderland.alice.component.card.Colour.RED;

public class HanselScoringStrategyTest extends ScoringStrategyTest {

    private final Node hansel = new Node(new Card(RED, new Hansel()));
    private final ScoringStrategy scoringStrategy = new HanselScoringStrategy();

    @Test
    public void IfGretelIsAroundShouldReturnThreePoints() {
        hansel.setRight(blue(new Gretel()), 1);
        assertEquals(3, scoringStrategy.execute(hansel));
    }

    @Test
    public void IfStepmotherIsAroundShouldDeductTwoPoints() {
        hansel.setRight(blue(new Stepmother()), 1);
        assertEquals(-2, scoringStrategy.execute(hansel));
    }

    @Test
    public void IfWitchIsAroundShouldDeductFivePoints() {
        hansel.setRight(blue(new Witch()), 1);
        assertEquals(-5, scoringStrategy.execute(hansel));
    }

    @Test
    public void testCombination() {
        hansel.setRight(blue(new Gretel()), 1);
        hansel.setBottom(blue(new Stepmother()), 1);
        hansel.setTop(blue(new Witch()), 1);
        assertEquals(-4, scoringStrategy.execute(hansel));
    }
}
