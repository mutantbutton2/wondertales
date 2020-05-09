package wonderland.alice.scoring.strategy;

import org.junit.Test;
import wonderland.alice.component.card.Card;
import wonderland.alice.component.card.character.*;
import wonderland.alice.scoring.Node;
import wonderland.alice.scoring.ScoringStrategy;

import static org.junit.Assert.assertEquals;
import static wonderland.alice.component.card.Colour.RED;

public class FrogPrinceScoringStrategyTest extends ScoringStrategyTest {

    private final Node redFrogPrince = new Node(new Card(RED, new FrogPrince()));
    private final ScoringStrategy scoringStrategy = new FrogPrinceScoringStrategy();

    @Test
    public void ifPrincessAroundShouldReturnThreePoints() {
        redFrogPrince.setLeft(blue(new Princess()), 1);
        assertEquals(3, scoringStrategy.execute(redFrogPrince));
    }

    @Test
    public void ifWithAroundSHouldDeductTwoPoints() {
        redFrogPrince.setLeft(blue(new Witch()), 1);
        assertEquals(-2, scoringStrategy.execute(redFrogPrince));
    }
    @Test
    public void SomeCombination() {
        redFrogPrince.setTop(blue(new Princess()), 1);
        redFrogPrince.setLeft(blue(new Witch()), 1);
        assertEquals(1, scoringStrategy.execute(redFrogPrince));
    }
}
