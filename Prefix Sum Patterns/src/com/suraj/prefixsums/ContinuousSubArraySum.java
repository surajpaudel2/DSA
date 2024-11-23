package com.suraj.prefixsums;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubArraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int temp = sum % k;

            if (temp < 0) {
                temp += k;
            }

            if (temp == 0 && i > 0) {
                return true;
            }

            if (map.containsKey(temp)) {
                if (i - map.get(temp) >= 2) {
                    return true;
                }
            } else {
                map.put(temp, i);
            }
        }
        return false;
    }
}
