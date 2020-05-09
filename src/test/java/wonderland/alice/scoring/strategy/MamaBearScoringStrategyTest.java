package wonderland.alice.scoring.strategy;

import org.junit.Test;
import wonderland.alice.component.card.Card;
import wonderland.alice.component.card.character.*;
import wonderland.alice.scoring.Node;
import wonderland.alice.scoring.ScoringStrategy;

import static org.junit.Assert.assertEquals;
import static wonderland.alice.component.card.Colour.RED;

public class MamaBearScoringStrategyTest extends ScoringStrategyTest {

    private final Node node = new Node(new Card(RED, new MamaBear()));
    private final ScoringStrategy scoringStrategy = new MamaBearScoringStrategy();

    @Test
    public void EachOpposingColourColourNeighbourShouldReturnOnePoint() {
        node.setRight(blue(new Grandma()), 1);
        assertEquals(1, scoringStrategy.execute(node));
    }

    @Test
    public void SameColourColourNeighbourShouldReturnNoPoint() {
        node.setRight(red(new Grandma()), 1);
        assertEquals(0, scoringStrategy.execute(node));
    }

    @Test
    public void ThreeOpposingNeighboursShouldReturnThreePoints() {
        node.setTop(blue(new Grandma()), 1);
        node.setBottom(blue(new PapaBear()), 1);
        node.setLeft(blue(new BabyBear()), 1);
        node.setRight(red(new Princess()), 1);
        assertEquals(3, scoringStrategy.execute(node));
    }
}
