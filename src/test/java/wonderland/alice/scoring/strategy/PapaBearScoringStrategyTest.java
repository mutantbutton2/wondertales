package wonderland.alice.scoring.strategy;

import org.junit.Test;
import wonderland.alice.component.card.Card;
import wonderland.alice.component.card.character.*;
import wonderland.alice.scoring.Node;
import wonderland.alice.scoring.ScoringStrategy;

import static org.junit.Assert.assertEquals;
import static wonderland.alice.component.card.Colour.BLUE;

public class PapaBearScoringStrategyTest extends ScoringStrategyTest {

    private final Node bluePapaBear = new Node(new Card(BLUE, new PapaBear()));
    private final ScoringStrategy scoringStrategy = new PapaBearScoringStrategy();

    @Test
    public void EachSameColourNeighbourShouldReturnOnePoint() {
        bluePapaBear.setRight(blue(new Grandma()), 1);
        assertEquals(1, scoringStrategy.execute(bluePapaBear));
    }

    @Test
    public void SameColourNeighbourShouldReturnNoPoint() {
        bluePapaBear.setRight(red(new Grandma()), 1);
        assertEquals(0, scoringStrategy.execute(bluePapaBear));
    }

    @Test
    public void ThreeOpposingNeighboursShouldReturnThreePoints() {
        bluePapaBear.setTop(blue(new Grandma()), 1);
        bluePapaBear.setBottom(blue(new PapaBear()), 1);
        bluePapaBear.setLeft(blue(new BabyBear()), 1);
        bluePapaBear.setRight(red(new Princess()), 1);
        assertEquals(3, scoringStrategy.execute(bluePapaBear));
    }
}
