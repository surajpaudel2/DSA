public class RecoverBST {
    public static void main(String[] args) {

    }

    public void recoverTree(TreeNode root) {
        TreeNode[] arr = new TreeNode[3];
        inorderTS(root, new TreeNode[]{null}, arr);

        int temp = arr[0].val;
        if (arr[2] != null) {
            arr[0].val = arr[2].val;
            arr[2].val = temp;
        } else {
            arr[0].val = arr[1].val;
            arr[1].val = temp;
        }

    }

    private void inorderTS(TreeNode root, TreeNode[] prev, TreeNode[] arr) {
        if (root == null) {
            return;
        }

        inorderTS(root.left, prev, arr);
        if (prev[0] != null) {
            if (root.val < prev[0].val) {
                if (arr[0] == null) {
                    arr[0] = prev[0];
                    arr[1] = root;
                } else {
                    arr[2] = root;
                }
            }
        }
        prev[0] = root;
        inorderTS(root.right, prev, arr);
    }
}
