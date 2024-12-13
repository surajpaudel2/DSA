package com.suraj.prefixsums;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SpecialArrayII {
    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 6};
        int[][] queries = {{0, 2}, {2, 3}};
        boolean[] ans = new SpecialArrayII().isArraySpecial(arr, queries);
        System.out.println(Arrays.toString(ans));
    }

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] prefixSums = new int[nums.length];

        int sum = 0;
        for(int i = 1; i < nums.length; i++) {
            if((nums[i] % 2 == 0 && nums[i - 1] % 2 == 0) || nums[i] % 2 != 0 && nums[i - 1] % 2 != 0) {
                sum++;
            }
            prefixSums[i] = sum;
        }

        System.out.println(Arrays.toString(prefixSums));

        boolean[] isArraySpecial = new boolean[queries.length];
        for(int i = 0; i < queries.length; i++) {
            if(prefixSums[queries[i][1]] - prefixSums[queries[i][0]] == 0) {
                isArraySpecial[i] = true;
            }
        }
        return isArraySpecial;
    }
}
