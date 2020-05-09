package wonderland.alice.scoring.strategy;

import org.junit.Test;
import wonderland.alice.component.card.Card;
import wonderland.alice.component.card.character.*;
import wonderland.alice.scoring.Node;
import wonderland.alice.scoring.ScoringStrategy;

import static org.junit.Assert.assertEquals;
import static wonderland.alice.component.card.Colour.BLUE;
import static wonderland.alice.component.card.Colour.RED;

public class LittlePigOneScoringStrategyTest extends ScoringStrategyTest {

    private final Node littlePigOne = new Node(new Card(BLUE, new LittlePigOne()));
    private final Node littlePigTwo = new Node(new Card(RED, new LittlePigTwo()));
    private final Node littlePigThree = new Node(new Card(BLUE, new LittlePigThree()));
    private final ScoringStrategy scoringStrategy = new LittlePigOneScoringStrategy();

    @Test
    public void IfAllPigsAreConnectedShouldReturnFivePoints() {
        littlePigTwo.setRight(littlePigThree, 1);
        littlePigTwo.setLeft(littlePigOne, 1);
        assertEquals(5, scoringStrategy.execute(littlePigTwo));
    }

    @Test
    public void IfAllPigsAreConnectedShouldReturnFivePoints2() {
        littlePigTwo.setRight(littlePigThree, 1);
        littlePigThree.setRight(littlePigOne, 1);
        assertEquals(5, scoringStrategy.execute(littlePigTwo));
    }

    @Test
    public void IfAllPigsAreConnectedShouldReturnFivePoints3() {
        littlePigTwo.setBottom(littlePigOne, 1);
        littlePigOne.setRight(littlePigThree, 1);
        assertEquals(5, scoringStrategy.execute(littlePigTwo));
    }

    @Test
    public void OnlyTwoPigsConnectedShouldReturnNoPoints() {
        littlePigTwo.setBottom(littlePigOne, 1);
        assertEquals(0, scoringStrategy.execute(littlePigTwo));
    }
}
