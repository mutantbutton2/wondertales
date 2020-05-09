package wonderland.alice.scoring.strategy;

import org.junit.Test;
import wonderland.alice.component.card.Card;
import wonderland.alice.component.card.character.Gretel;
import wonderland.alice.component.card.character.Hansel;
import wonderland.alice.component.card.character.Stepmother;
import wonderland.alice.component.card.character.Witch;
import wonderland.alice.scoring.Node;
import wonderland.alice.scoring.ScoringStrategy;

import static org.junit.Assert.assertEquals;
import static wonderland.alice.component.card.Colour.RED;

public class GretelScoringStrategyTest extends ScoringStrategyTest {

    private final Node gretel = new Node(new Card(RED, new Gretel()));
    private final ScoringStrategy scoringStrategy = new GretelScoringStrategy();

    @Test
    public void IfHanselIsAroundShouldReturnThreePoints() {
        gretel.setRight(blue(new Hansel()), 1);
        assertEquals(3, scoringStrategy.execute(gretel));
    }

    @Test
    public void IfStepmotherIsAroundShouldDeductTwoPoints() {
        gretel.setRight(blue(new Stepmother()), 1);
        assertEquals(-2, scoringStrategy.execute(gretel));
    }

    @Test
    public void IfWitchIsAroundShouldDeductFourPoints() {
        gretel.setRight(blue(new Witch()), 1);
        assertEquals(-4, scoringStrategy.execute(gretel));
    }

    @Test
    public void testCombination() {
        gretel.setRight(blue(new Hansel()), 1);
        gretel.setBottom(blue(new Stepmother()), 1);
        gretel.setTop(blue(new Witch()), 1);
        assertEquals(-3, scoringStrategy.execute(gretel));
    }
}
