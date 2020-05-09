package wonderland.alice.scoring.strategy;

import org.junit.Test;
import wonderland.alice.component.card.Card;
import wonderland.alice.component.card.character.*;
import wonderland.alice.scoring.Node;
import wonderland.alice.scoring.ScoringStrategy;

import static org.junit.Assert.assertEquals;
import static wonderland.alice.component.card.Colour.RED;

public class GoldilocksScoringStrategyTest extends ScoringStrategyTest {

    private final Node redWoodcutter = new Node(new Card(RED, new Goldilocks()));
    private final ScoringStrategy scoringStrategy = new GoldilocksScoringStrategy();

    @Test
    public void ifAnyBearIsAroundShouldReturnNoPoints() {
        redWoodcutter.setLeft(blue(new PapaBear()), 1);
        assertEquals(0, scoringStrategy.execute(redWoodcutter));
    }

    @Test
    public void ifAllBearsAreNotAroundShouldReturnFivePoints() {
        redWoodcutter.setLeft(blue(new Gretel()), 1);
        redWoodcutter.setRight(blue(new Witch()), 1);
        redWoodcutter.setTop(blue(new Woodcutter()), 1);
        assertEquals(5, scoringStrategy.execute(redWoodcutter));
    }
}
