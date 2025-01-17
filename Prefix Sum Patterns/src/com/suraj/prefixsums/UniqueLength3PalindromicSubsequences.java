package com.suraj.prefixsums;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueLength3PalindromicSubsequences {
    public static void main(String[] args) {
        String str = "bbcbaba";
        int ans = new UniqueLength3PalindromicSubsequences().countPalindromicSubsequence(str);
        System.out.println(ans);
    }

    public int countPalindromicSubsequence(String s) {
        Map<Character, int[]> map = new HashMap<Character, int[]>();
        Set<String> visited = new HashSet<>();

        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int[] arr = null;
            if(map.containsKey(s.charAt(i))) {
                arr = map.get(s.charAt(i));
            } else {
                arr = new int[2];
                arr[0] = i;
                map.put(s.charAt(i), arr);
            }

            arr[1]++;

            if(arr[1] >= 2) {
                for(int j = arr[0] + 1; j < i; j++) {
                    if(s.charAt(j) == s.charAt(i)) {
                        continue;
                    }
                    String str = ""+s.charAt(i) + s.charAt(j) + s.charAt(i);
                    if(!visited.contains(str)) {
                        ans++;
                        visited.add(str);
                    }
                }
            }

            if(arr[1] == 3) {
                String str = ""+s.charAt(i) + s.charAt(i) + s.charAt(i);
                if(!visited.contains(str)) {
                    visited.add(str);
                    ans++;
                }
                arr[1] = 1;
                arr[0] = i;
            }
        }
        return ans;
    }
}
