public class DeleteANodeInBST {
    public static void main(String[] args) {

    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(root.val == key && root.left == null && root.right == null) {
            return null;
        } else if(root.val == key && root.left == null) {
            return root.right;
        } else if(root.val == key && root.right == null) {
            return root.left;
        } else if(root.val == key) {
            int lMax = findMaxFromLeft(root.left);
            root.val = lMax;
            deleteNode(root.left, root.val);
        }
        else if(root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }

    public int findMaxFromLeft(TreeNode root) {
        if(root.left == null && root.right == null) {
            return root.val;
        }

        return findMaxFromLeft(root.right);
    }
}
