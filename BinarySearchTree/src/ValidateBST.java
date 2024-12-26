public class ValidateBST {
    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        return solve(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean solve(TreeNode root, long min, long max) {
        if (root == null) return true;

        if (root.val < min || root.val > max) return false;

        boolean left = solve(root.left, min, root.val);
        boolean right = solve(root.right, root.val, max);

        return left && right;
    }
}
