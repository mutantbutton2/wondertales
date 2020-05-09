package wonderland.alice.scoring.strategy;

import org.junit.Test;
import wonderland.alice.component.card.Card;
import wonderland.alice.component.card.character.*;
import wonderland.alice.scoring.Node;
import wonderland.alice.scoring.ScoringStrategy;

import static org.junit.Assert.assertEquals;
import static wonderland.alice.component.card.Colour.RED;

public class WoodcutterScoringStrategyTest extends ScoringStrategyTest {

    private final Node redWoodcutter = new Node(new Card(RED, new Woodcutter()));
    private final ScoringStrategy scoringStrategy = new WoodcutterScoringStrategy();

    @Test
    public void ifGretelAroundShouldReturnTwoPoints() {
        redWoodcutter.setLeft(blue(new Gretel()), 1);
        assertEquals(2, scoringStrategy.execute(redWoodcutter));
    }

    @Test
    public void ifHanselAroundShouldReturnTwoPoints() {
        redWoodcutter.setLeft(blue(new Hansel()), 1);
        assertEquals(2, scoringStrategy.execute(redWoodcutter));
    }

    @Test
    public void isStepmotherAroundShouldReturnOnePoint() {
        redWoodcutter.setLeft(blue(new Stepmother()), 1);
        assertEquals(1, scoringStrategy.execute(redWoodcutter));
    }

    @Test
    public void SomeCombination() {
        redWoodcutter.setTop(blue(new Gretel()), 1);
        redWoodcutter.setLeft(blue(new Hansel()), 1);
        redWoodcutter.setRight(blue(new Stepmother()), 1);
        assertEquals(5, scoringStrategy.execute(redWoodcutter));
    }
}
