package wonderland.alice.scoring.strategy;

import org.junit.Test;
import wonderland.alice.component.card.Card;
import wonderland.alice.component.card.character.Grandma;
import wonderland.alice.component.card.character.LittleRedRidingHood;
import wonderland.alice.component.card.character.Woodcutter;
import wonderland.alice.scoring.Node;
import wonderland.alice.scoring.ScoringStrategy;

import static org.junit.Assert.assertEquals;
import static wonderland.alice.component.card.Colour.RED;

public class LittleRedRidingHoodScoringStrategyTest extends ScoringStrategyTest {

    private final Node node = new Node(new Card(RED, new LittleRedRidingHood()));
    private final ScoringStrategy scoringStrategy = new LittleRedRidingHoodScoringStrategy();

    @Test
    public void GrandmaOnTheRightShouldReturnTwoPoints() {
        node.setRight(blue(new Grandma()), 1);
        assertEquals(2, scoringStrategy.execute(node));
    }

    @Test
    public void GrandmaOnTheTopShouldReturnTwoPoints() {
        node.setTop(blue(new Grandma()), 1);
        assertEquals(2, scoringStrategy.execute(node));
    }

    @Test
    public void GrandmaOnTheLeftShouldReturnTwoPoints() {
        node.setLeft(blue(new Grandma()), 1);
        assertEquals(2, scoringStrategy.execute(node));
    }

    @Test
    public void GrandmaOnTheBottomShouldReturnTwoPoints() {
        node.setBottom(blue(new Grandma()), 1);
        assertEquals(2, scoringStrategy.execute(node));
    }
    @Test
    public void WoodCutterOnTheRightShouldReturnTwoPoints() {
        node.setRight(blue(new Woodcutter()), 1);
        assertEquals(1, scoringStrategy.execute(node));
    }

    @Test
    public void WoodcutterOnTheTopShouldReturnTwoPoints() {
        node.setTop(blue(new Woodcutter()), 1);
        assertEquals(1, scoringStrategy.execute(node));
    }

    @Test
    public void WoodcutterOnTheLeftShouldReturnTwoPoints() {
        node.setLeft(blue(new Woodcutter()), 1);
        assertEquals(1, scoringStrategy.execute(node));
    }

    @Test
    public void WoodcutterOnTheBottomShouldReturnTwoPoints() {
        node.setBottom(blue(new Woodcutter()), 1);
        assertEquals(1, scoringStrategy.execute(node));
    }

    @Test
    public void BothWoodCutterAndGrandmaShouldReturnThreePoints() {
        node.setBottom(blue(new Woodcutter()), 1);
        node.setTop(blue(new Grandma()), 1);
        assertEquals(3, scoringStrategy.execute(node));
    }
}
