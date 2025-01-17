import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class BSTIterator {
    Queue<Integer> q;

    public BSTIterator(TreeNode root) {
        q = new LinkedList<Integer>();
        inOrder(root);
    }

    public int next() {
        return q.poll();
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        q.offer(root.val);
        inOrder(root.right);
    }
}