package wonderland.alice.scoring;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import wonderland.alice.component.card.Card;
import wonderland.alice.component.card.character.MamaBear;
import wonderland.alice.component.card.character.PapaBear;
import wonderland.alice.matcher.CardMatcher;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static wonderland.alice.component.card.Colour.BLUE;
import static wonderland.alice.component.card.Colour.RED;

@RunWith(MockitoJUnitRunner.class)
public class NodeTest {

    @Mock
    private CardMatcher cardMatcherA;

    @Mock
    private CardMatcher cardMatcherB;

    private final Card cardA = new Card(RED, new PapaBear());
    private final Card cardB = new Card(BLUE, new MamaBear());
    private final Node nodeA = new Node(cardA);
    private final Node nodeB = new Node(cardB);
    private final Node nodeC = new Node(cardB);
    private final Node nodeD = new Node(cardB);

    @Test
    public void testTwoNodesSideBySide() {
        nodeA.setRight(nodeB, 1);
        assertEquals(nodeA.right, nodeB);
        assertEquals(nodeB.left, nodeA);
    }

    @Test
    public void testTwoNodeTopToBottom() {
        nodeA.setBottom(nodeB, 1);
        assertEquals(nodeA.bottom, nodeB);
        assertEquals(nodeB.top, nodeA);
    }

    @Test
    public void testLongest1() {
        when(cardMatcherB.match(cardB)).thenReturn(true);
        assertEquals(1, nodeB.furthest(cardMatcherB));
    }

    @Test
    public void testRightLongest1() {
        nodeB.setRight(nodeC, 1);
        when(cardMatcherB.match(cardB)).thenReturn(true);
        assertEquals(2, nodeB.furthest(cardMatcherB));
    }

    @Test
    public void testRightLongest2() {
        nodeB.setRight(nodeC, 1);
        nodeC.setRight(nodeD, 1);
        when(cardMatcherB.match(cardB)).thenReturn(true);
        assertEquals(3, nodeB.furthest(cardMatcherB));
    }

    @Test
    public void testRightLongest3() {
        nodeB.setRight(nodeC, 1);
        nodeC.setRight(nodeD, 1);
        when(cardMatcherB.match(cardB)).thenReturn(true);
        assertEquals(3, nodeC.furthest(cardMatcherB));
    }

    @Test
    public void testBottomLongest() {
        nodeB.setBottom(nodeC, 1);
        when(cardMatcherB.match(cardB)).thenReturn(true);
        assertEquals(2, nodeB.furthest(cardMatcherB));
    }

    @Test
    public void testMixLongest1() {
        nodeB.setRight(nodeC, 1);
        nodeC.setTop(nodeD, 1);
        nodeD.setRight(nodeA, 1);
        when(cardMatcherB.match(cardB)).thenReturn(true);
        assertEquals(3, nodeB.furthest(cardMatcherB));
    }

}
