package wonderland.alice.scoring;

import java.util.HashSet;
import java.util.Set;

public class Node<T> {

    public final T value;
    public Node<T> top;
    public Node<T> bottom;
    public Node<T> right;
    public Node<T> left;

    public Node(T value) {
        this.value = value;
        this.top = null;
        this.bottom = null;
        this.right = null;
        this.left = null;
    }

    public void setTop(Node<T> top, int n) {
        if (n >= 0) {
            this.top = top;
            top.setBottom(this, n-1);
        }
    }

    public void setBottom(Node<T> bottom, int n) {
        if (n >= 0) {
            this.bottom = bottom;
            bottom.setTop(this, n-1);
        }
    }

    public void setRight(Node<T> right, int n) {
        if (n >= 0) {
            this.right = right;
            right.setLeft(this, n-1);
        }
    }

    public void setLeft(Node<T> left, int n) {
        if (n >= 0) {
            this.left = left;
            left.setRight(this, n-1);
        }
    }

    public int furthest(T target) {
        return furthest2(target, new HashSet<>(), false);
    }

    // TODO: Ehhhh
    public int furthest2(T target, Set<Node<T>> visited, boolean include) {
        visited.add(this);
        if (!include || target.equals(value)) {
            int topResult    = top    == null || visited.contains(top)    ? 0 : top.furthest2(target, visited, true);
            int bottomResult = bottom == null || visited.contains(bottom) ? 0 : bottom.furthest2(target, visited, true);
            int leftResult   = left   == null || visited.contains(left)   ? 0 : left.furthest2(target, visited, true);
            int rightResult  = right  == null || visited.contains(right)  ? 0 : right.furthest2(target, visited, true);
            return (include ? 1 : 0) + Math.max(topResult, Math.max(bottomResult, Math.max(leftResult, rightResult)));
        }
        return 0;
    }

}
