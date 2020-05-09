package wonderland.alice.scoring.strategy;

import org.junit.Test;
import wonderland.alice.component.card.Card;
import wonderland.alice.component.card.character.*;
import wonderland.alice.scoring.Node;
import wonderland.alice.scoring.ScoringStrategy;

import static org.junit.Assert.assertEquals;
import static wonderland.alice.component.card.Colour.BLUE;

public class BabyBearScoringStrategyTest extends ScoringStrategyTest {

    private final Node papaBear = new Node(new Card(BLUE, new PapaBear()));
    private final Node babyBear = new Node(new Card(BLUE, new BabyBear()));
    private final Node mamaBear = new Node(new Card(BLUE, new MamaBear()));
    private final ScoringStrategy scoringStrategy = new BabyBearScoringStrategy();

    @Test
    public void IfAllBearsAreConnectedShouldReturnFivePoints() {
        babyBear.setRight(mamaBear, 1);
        babyBear.setLeft(papaBear, 1);
        assertEquals(5, scoringStrategy.execute(babyBear));
    }

    @Test
    public void IfAllBearsAreConnectedShouldReturnFivePoints2() {
        babyBear.setRight(mamaBear, 1);
        mamaBear.setRight(papaBear, 1);
        assertEquals(5, scoringStrategy.execute(babyBear));
    }

    @Test
    public void IfAllBearsAreConnectedShouldReturnFivePoints3() {
        babyBear.setBottom(papaBear, 1);
        papaBear.setRight(mamaBear, 1);
        assertEquals(5, scoringStrategy.execute(babyBear));
    }

    @Test
    public void OnlyTwoBearConnectedShouldReturnNoPoints() {
        babyBear.setBottom(papaBear, 1);
        assertEquals(0, scoringStrategy.execute(babyBear));
    }
}
