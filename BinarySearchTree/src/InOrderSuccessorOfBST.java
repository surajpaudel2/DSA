import java.util.ArrayList;
import java.util.List;

public class InOrderSuccessorOfBST {
    public static void main(String[] args) {

    }

    public int inorderSuccessor(Node root, Node x) {
        List<Integer> li = new ArrayList<>();
        inOrder(root, li);

        for (int i = 0; i < li.size(); i++) {
            if (li.get(i) == x.data && i + 1 < li.size()) {
                return li.get(i + 1);
            }
        }
        return -1;
    }

    public void inOrder(Node root, List<Integer> li) {
        if (root == null) {
            return;
        }
        inOrder(root.left, li);
        li.add(root.data);
        inOrder(root.right, li);
    }


    /*
        Below is the optimized code to find the inorder successor in a BST.
     */

    int ans = -1;
    boolean xFound = false;

    public int inorderSuccessorOptimized(Node root, Node x) {
        if (ans != -1) return ans;

        if (root == null) {
            return ans;
        }

        inorderSuccessorOptimized(root.left, x);
        if (xFound && ans == -1) {
            ans = root.data;
        }
        if (x == root) {
            xFound = true;
        }
        inorderSuccessorOptimized(root.right, x);
        return ans;
    }
}
