package com.suraj.prefixsums;

public class FindPivotIndex {
    public static void main(String[] args) {
        int[] arr = {1, 7, 3, 6, 5, 6};
        int ans = new FindPivotIndex().pivotIndex(arr);
        System.out.println(ans);
    }

    public int pivotIndex(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        int sum2 = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            sum2 += nums[i - 1];
            sum -= nums[i - 1];
            if (sum - nums[i] == sum2) {
                return i;
            }
        }
        return -1;
    }
}
