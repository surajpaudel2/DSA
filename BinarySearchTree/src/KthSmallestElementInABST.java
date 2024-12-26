public class KthSmallestElementInABST {
    public static void main(String[] args) {

    }

    int ind = 0, ans = -1;

    public int kthSmallest(TreeNode root, int k) {
        solve(root, k);
        return ans;
    }

    public void solve(TreeNode root, int k) {
        if (ans != -1) {
            return;
        }

        if (root == null) {
            return;
        }

        solve(root.left, k);
        ind++;
        if (ind == k) {
            ans = root.val;
        }
        solve(root.right, k);
    }

    /*
        => Below function avoids to use the global variable
     */
    public void kthSmallestWithoutGlobalVariable(TreeNode root, int[] arr, int k) {
        if(arr[0] != -1) {
            return;
        }

        if(root == null) {
            return;
        }

        kthSmallestWithoutGlobalVariable(root.left, arr, k);
        arr[1]++;
        if(arr[1] == k) {
            arr[0] = root.val;
        }
        kthSmallestWithoutGlobalVariable(root.right, arr, k);
    }
}
