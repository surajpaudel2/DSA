public class LargestBSTInABT {
    public static void main(String[] args) {

    }

    static int largestBst(Node root) {
        return solve(root).ans;
    }

    static class Bst {
        int ans;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    }

    static Bst solve(Node root) {
        if (root == null) {
            return new Bst();
        }

        Bst sp1 = solve(root.left);
        Bst sp2 = solve(root.right);

        Bst bst = new Bst();
       if(root.data > sp1.max && root.data < sp2.min) {
           bst.ans = 1 + sp1.ans + sp2.ans;
           bst.min = Math.min(root.data, sp1.min);
           bst.max = Math.max(root.data, sp2.max);
       } else {
           bst.ans = Math.max(sp1.ans, sp2.ans);
           bst.min = Integer.MIN_VALUE;
           bst.max = Integer.MAX_VALUE;
       }
        return bst;
    }
}
