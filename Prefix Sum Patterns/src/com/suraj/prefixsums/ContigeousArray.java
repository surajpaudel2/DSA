package com.suraj.prefixsums;

import java.util.HashMap;
import java.util.Map;

public class ContigeousArray {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1, 1, 0, 1, 0, 1, 1};
        int ans = new ContigeousArray().findMaxLength(arr);
        System.out.println(ans);
    }

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int sum = 0, ans = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                sum += -1;
            } else {
                sum++;
            }

            if(map.containsKey(sum)) {
                ans = Math.max(ans, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return ans;
    }
}