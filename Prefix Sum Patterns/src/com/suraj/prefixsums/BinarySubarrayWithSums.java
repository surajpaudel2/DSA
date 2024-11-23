package com.suraj.prefixsums;

import java.util.HashMap;
import java.util.Map;

public class BinarySubarrayWithSums {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0, 1, 0, 0, 0, 1};
        int ans = new BinarySubarrayWithSums().approach2(arr, 2);
        System.out.println(ans);
    }


    //	Approach 1 : with O(N) space
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);

        int sum = 0, ans = 0;
        for(int i : nums) {
            sum += i;
            if(map.containsKey(sum - goal)) {
                ans += map.get(sum - goal);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

//	 Approach 2 : With O(1) Space

    public int approach2(int[] nums, int goal) {
        return findTotalNumsOfSubArrayEqualOrLess(nums, goal) - findTotalNumsOfSubArrayEqualOrLess(nums, goal - 1);
    }

    public int findTotalNumsOfSubArrayEqualOrLess(int[] nums, int goal) {
        int i = 0, sum = 0, res = 0;
        for(int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while(sum > goal) {
                sum -= nums[i];
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }
}

















