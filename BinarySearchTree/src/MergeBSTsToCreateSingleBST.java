import java.util.*;

public class MergeBSTsToCreateSingleBST {
    public static void main(String[] args) {

    }

    /*
        ->

     */

    public TreeNode canMerge(List<TreeNode> trees) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> leaves = new HashSet<>();

        // Populate map with root nodes and track leaf nodes
        for (TreeNode tr : trees) {
            map.put(tr.val, tr);
            if (tr.left != null) leaves.add(tr.left.val);
            if (tr.right != null) leaves.add(tr.right.val);
        }

        // Find the root candidate (only non-leaf root node)
        TreeNode root = null;
        for (TreeNode tr : trees) {
            if (!leaves.contains(tr.val)) {
                if (root != null) return null; // Multiple root candidates
                root = tr;
            }
        }
        if (root == null) return null; // No valid root

        merge(root, map);
        // Merge trees starting from the root
        if (map.size() > 1) return null;

        // Validate the resulting tree is a BST
        return isBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE) ? root : null;
    }

    private void merge(TreeNode tr, Map<Integer, TreeNode> map) {
        if (tr == null) return;

        // Merge left subtree
        if (tr.left != null && map.containsKey(tr.left.val)) {
            tr.left = map.remove(tr.left.val);
        }

        // Merge right subtree
        if (tr.right != null && map.containsKey(tr.right.val)) {
            tr.right = map.remove(tr.right.val);
        }

        merge(tr.left, map);
        merge(tr.right, map);
    }

    private boolean isBST(TreeNode tr, int max, int min) {
        if (tr == null) return true;
        if (tr.val <= min || tr.val >= max) return false;
        return isBST(tr.left, tr.val, min) && isBST(tr.right, max, tr.val);
    }
}
