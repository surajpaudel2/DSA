import java.util.Stack;

public class BSTIterator {
    TreeNode root;
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.root = root;
        this.stack = new Stack<>();
    }

    public int next() {
        if (root.left != null) {
            stack.push(root);
            root = root.left;
            return root.val;
        }

        TreeNode temp = null;
        while (!stack.isEmpty() && (stack.peek().right == null || stack.peek().right == temp)) {
            temp = stack.pop();
        }
        if (!stack.isEmpty() && stack.peek().right != null) {
            root = stack.peek().right;
            stack.push(root);
        } else {
            root = null;
        }
        return root == null ? -1 : root.val;
    }

    public boolean hasNext() {
        if (root.left != null || root.right != null) {
            return true;
        }

        TreeNode temp = null;
        Stack<TreeNode> tempStack = new Stack<>();

        while (!stack.isEmpty() && (stack.peek().right == null || stack.peek().right == temp)) {
            temp = stack.pop();
            tempStack.push(temp);
        }

        boolean b = false;
        if (!stack.isEmpty() && stack.peek().right != null) {
            b = true;
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        return b;
    }
}
