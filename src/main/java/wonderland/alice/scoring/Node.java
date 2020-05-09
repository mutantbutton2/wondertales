package wonderland.alice.scoring;

import wonderland.alice.component.card.Card;
import wonderland.alice.matcher.CardMatcher;

import java.util.HashSet;
import java.util.Set;

import static wonderland.alice.component.card.Card.emptyCard;

public class Node {

    public final Card card;
    public Node top;
    public Node bottom;
    public Node right;
    public Node left;

    public Node(Card card) {
        this.card = card;
        this.top = null;
        this.bottom = null;
        this.right = null;
        this.left = null;
    }

    public void setTop(Node top, int n) {
        if (n >= 0) {
            this.top = top;
            top.setBottom(this, n-1);
        }
    }

    public void setBottom(Node bottom, int n) {
        if (n >= 0) {
            this.bottom = bottom;
            bottom.setTop(this, n-1);
        }
    }

    public void setRight(Node right, int n) {
        if (n >= 0) {
            this.right = right;
            right.setLeft(this, n-1);
        }
    }

    public void setLeft(Node left, int n) {
        if (n >= 0) {
            this.left = left;
            left.setRight(this, n-1);
        }
    }

    private Card getLeftCard() {
        return left == null ? emptyCard() : left.card;
    }

    private Card getRightCard() {
        return right == null ? emptyCard() : right.card;
    }

    private Card getTopCard() {
        return top == null ? emptyCard() : top.card;
    }

    private Card getBottomCard() {
        return bottom == null ? emptyCard() : bottom.card;
    }

    public int furthest(CardMatcher matcher) {
        return furthest2(matcher, new HashSet<>());
    }

    // TODO: Ehhhh
    public int furthest2(CardMatcher matcher, Set<Node> visited) {
        visited.add(this);
        if (matcher.match(card)) {
            int topResult    = top    == null || visited.contains(top)    ? 0 : top.furthest2(matcher, visited);
            int bottomResult = bottom == null || visited.contains(bottom) ? 0 : bottom.furthest2(matcher, visited);
            int leftResult   = left   == null || visited.contains(left)   ? 0 : left.furthest2(matcher, visited);
            int rightResult  = right  == null || visited.contains(right)  ? 0 : right.furthest2(matcher, visited);
            return 1 + topResult + bottomResult + leftResult + rightResult;
        }
        return 0;
    }

    public int connected(CardMatcher cardMatcher) {
        int top = cardMatcher.match(getTopCard()) ? 1 : 0;
        int bottom = cardMatcher.match(getBottomCard()) ? 1 : 0;
        int left = cardMatcher.match(getLeftCard()) ? 1 : 0;
        int right = cardMatcher.match(getRightCard()) ? 1 : 0;
        return top + bottom + left + right;
    }

}
