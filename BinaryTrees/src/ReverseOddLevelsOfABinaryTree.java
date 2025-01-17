import java.util.LinkedList;
import java.util.Queue;

public class ReverseOddLevelsOfABinaryTree {
    public static void main(String[] args) {

    }

    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) {
            return null;
        }

        LinkedList<TreeNode> ll = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean b = false;

        while (!q.isEmpty()) {
            int size = q.size();
            if (!b) {
                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();
                    if (node.left != null) {
                        q.offer(node.left);
                        q.offer(node.right);
                        ll.add(node.left);
                        ll.add(node.right);
                    }
                }
                b = true;
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();
                    if (!ll.isEmpty()) {
                        TreeNode lastNode = ll.removeLast();
                        TreeNode firstNode = ll.removeFirst();
                        int temp = lastNode.val;
                        lastNode.val = firstNode.val;
                        firstNode.val = temp;
                    }
                    if (node.left != null) {
                        q.offer(node.left);
                        q.offer(node.right);
                    }
                }
                b = false;
            }
        }
        return root;
    }


    /*
        => Below is optimized version of the above problem.
     */
    public TreeNode reverseOddLevelsOptimized(TreeNode root) {
        if(root == null) {
            return null;
        }
        reverse(root.left, root.right, 1);
        return root;
    }

    public void reverse(TreeNode leftNode, TreeNode rightNode, int level) {
        if(leftNode == null || rightNode == null) {
            return;
        }

        if(level % 2 != 0) {
            int temp = rightNode.val;
            rightNode.val = leftNode.val;
            leftNode.val = temp;
        }
        reverse(leftNode.left, rightNode.right, level + 1);
        reverse(leftNode.right, rightNode.left, level + 1);
    }
}