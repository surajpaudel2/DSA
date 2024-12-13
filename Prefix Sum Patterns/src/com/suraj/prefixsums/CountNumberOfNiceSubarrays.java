package com.suraj.prefixsums;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfNiceSubarrays {
    public static void main(String[] args) {

    }

    /*
        This is approach 2, this question can be done with sliding window as well in O(N) time complexity and O(1)
        space complexity.
     */
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, ans = 0;

        for(int i : nums) {
            if(i % 2 != 0) {
                count++;
            }
            map.put(count, map.getOrDefault(count, 0) + 1);

            if(map.containsKey(count - k)) {
                ans += map.get(count - k);
            }
        }
        return ans;
    }
}
