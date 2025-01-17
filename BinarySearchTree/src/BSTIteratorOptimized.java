import java.util.Stack;

public class BSTIteratorOptimized {
    Stack<TreeNode> stack;

    public BSTIteratorOptimized(TreeNode root) {
        stack = new Stack<>();
        stack.push(root);
    }

    public int next() {
        pushLeftNodes(stack.peek());
        TreeNode curr = stack.pop();

        if (!stack.isEmpty()) {
            stack.peek().left = null;
        }

        if(curr.right != null) {
            stack.push(curr.right);
        }

        return curr.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushLeftNodes(TreeNode curr) {
        while (curr.left != null) {
            stack.push(curr.left);
            curr = curr.left;
        }
    }
}
