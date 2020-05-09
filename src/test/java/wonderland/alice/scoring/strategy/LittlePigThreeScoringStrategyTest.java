package wonderland.alice.scoring.strategy;

import org.junit.Test;
import wonderland.alice.component.card.Card;
import wonderland.alice.component.card.character.BigBadWolf;
import wonderland.alice.component.card.character.LittlePigThree;
import wonderland.alice.scoring.Node;
import wonderland.alice.scoring.ScoringStrategy;

import static org.junit.Assert.assertEquals;
import static wonderland.alice.component.card.Colour.RED;

public class LittlePigThreeScoringStrategyTest extends ScoringStrategyTest {

    private final Node littlePigThree = new Node(new Card(RED, new LittlePigThree()));
    private final ScoringStrategy scoringStrategy = new LittlePigThreeScoringStrategy();

    @Test
    public void IfBigBadWolfIsAroundShouldDeductFivePoints() {
        littlePigThree.setRight(blue(new BigBadWolf()), 1);
        assertEquals(-5, scoringStrategy.execute(littlePigThree));
    }

}
