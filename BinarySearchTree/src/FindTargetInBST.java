import java.util.HashSet;
import java.util.Set;

/*
    NOTE:
        This question can be done with binary search style as well by checking whether the k - root.val lies in the
        tree or not.
 */

public class FindTargetInBST {
    public static void main(String[] args) {

    }

    public boolean findTarget(TreeNode root, int k) {
        if (root == null || (root.left == null && root.right == null)) {
            return false;
        }
        Set<Integer> set = new HashSet<Integer>();
        store(root, set);
        return exists(root, k, set);
    }

    public boolean exists(TreeNode root, int k, Set<Integer> set) {
        if (root == null) return false;

        if (set.contains(k - root.val) && (k - root.val) != root.val) return true;

        return exists(root.left, k, set) || exists(root.right, k, set);
    }

    public void store(TreeNode root, Set<Integer> set) {
        if (root == null) return;

        set.add(root.val);
        store(root.left, set);
        store(root.right, set);
    }
}
