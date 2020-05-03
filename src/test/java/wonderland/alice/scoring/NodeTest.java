package wonderland.alice.scoring;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NodeTest {

    private final Node<Integer> nodeA = new Node<>(1);
    private final Node<Integer> nodeB = new Node<>(0);
    private final Node<Integer> nodeC = new Node<>(0);
    private final Node<Integer> nodeD = new Node<>(0);

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
    public void testRightLongest1() {
        nodeA.setRight(nodeB, 1);
        assertEquals(0, nodeA.furthest(1));
    }

    @Test
    public void testRightLongest2() {
        nodeA.setRight(nodeB, 1);
        assertEquals(1, nodeA.furthest(0));
    }

    @Test
    public void testRightLongest3() {
        nodeA.setRight(nodeB, 1);
        nodeB.setRight(nodeC, 1);
        nodeC.setRight(nodeD, 1);
        assertEquals(3, nodeA.furthest(0));
    }

    @Test
    public void testBottomLongest1() {
        nodeA.setBottom(nodeB, 1);
        assertEquals(0, nodeA.furthest(1));
    }

    @Test
    public void testBottomLongest2() {
        nodeA.setBottom(nodeB, 1);
        assertEquals(1, nodeA.furthest(0));
    }

    @Test
    public void testBottomLongest3() {
        nodeA.setBottom(nodeB, 1);
        nodeB.setBottom(nodeC, 1);
        nodeC.setBottom(nodeD, 1);
        assertEquals(3, nodeA.furthest(0));
    }

    @Test
    public void testMixLongest1() {
        nodeA.setRight(nodeB, 1);
        nodeB.setRight(nodeC, 1);
        nodeC.setTop(nodeD, 1);
        assertEquals(3, nodeA.furthest(0));
    }

    @Test
    public void testMixLongest2() {
        nodeA.setRight(nodeB, 1);
        nodeA.setBottom(nodeC, 1);
        nodeD.setTop(nodeB, 1);
        nodeD.setLeft(nodeC, 1);
        assertEquals(3, nodeA.furthest(0));
    }

}
