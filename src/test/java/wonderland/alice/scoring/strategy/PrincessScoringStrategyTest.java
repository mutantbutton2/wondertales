package wonderland.alice.scoring.strategy;

import org.junit.Test;
import wonderland.alice.component.card.Card;
import wonderland.alice.component.card.character.Grandma;
import wonderland.alice.component.card.character.PapaBear;
import wonderland.alice.component.card.character.Princess;
import wonderland.alice.scoring.Node;
import wonderland.alice.scoring.ScoringStrategy;

import static org.junit.Assert.assertEquals;
import static wonderland.alice.component.card.Colour.RED;

public class PrincessScoringStrategyTest extends ScoringStrategyTest {

    private final Node redPrincess = new Node(new Card(RED, new Princess()));
    private final ScoringStrategy scoringStrategy = new PrincessScoringStrategy();

    @Test
    public void EachNeighbourShouldReturnOnePoint() {
        redPrincess.setRight(blue(new Grandma()), 1);
        redPrincess.setLeft(red(new PapaBear()), 1);
        assertEquals(2, scoringStrategy.execute(redPrincess));
    }
}
