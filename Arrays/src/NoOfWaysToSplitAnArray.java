public class NoOfWaysToSplitAnArray {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0};
        int ans = new NoOfWaysToSplitAnArray().waysToSplitArray(arr);
        System.out.println(ans);
    }

    public int waysToSplitArray(int[] nums) {
        long totalSum = findTotalSum(nums);
        long currSum = 0;
        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            currSum += nums[i];
            totalSum -= nums[i];

            if (totalSum <= currSum) {
                count++;
            }
        }
        return count;
    }

    private long findTotalSum(int[] nums) {
        long sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return sum;
    }
}
