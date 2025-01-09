public class MaxChunxToMakeArraySorted {
    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 3, 4};
        int ans = new MaxChunxToMakeArraySorted().maxChunksToSorted(arr);
        System.out.println(ans);
    }

    public int maxChunksToSorted(int[] arr) {
        int max = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                ans++;
                max = Integer.MIN_VALUE;
            }
        }
        return ans;
    }
}
