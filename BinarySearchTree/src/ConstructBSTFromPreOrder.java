public class ConstructBSTFromPreOrder {
    public static void main(String[] args) {

    }

    int ind = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return construct(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode construct(int[] pre, int min, int max) {
        if(ind >= pre.length) {
            return null;
        }

        if(pre[ind] > min && pre[ind] < max) {
            TreeNode root = new TreeNode(pre[ind]);
            ind++;
            root.left = construct(pre, min, pre[ind - 1]);
            root.right = construct(pre, pre[ind - 1], max);
            return root;
        }
        return null;
    }
}
