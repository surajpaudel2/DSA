import com.sun.source.tree.Tree;

import java.util.Set;
import java.util.TreeSet;

//Link : https://leetcode.com/problems/continuous-subarrays/
public class ContinuousSubarrays {
    public static void main(String[] args) {
//        int[] arr = {5, 4, 2, 4};
        int[] arr = {65, 66, 67, 66, 66, 65, 64, 65, 65, 64};
//        long ans = new ContinuousSubarrays().continuousSubarrays(arr);
        long ans = new ContinuousSubarrays().continuousSubarraysOptimized(arr);

        System.out.println(ans);
    }

    public long continuousSubarrays(int[] nums) {
        TreeSet<Integer> maxiSet = new TreeSet<>((a, b) -> {
            if (nums[a] != nums[b]) {
                return nums[b] - nums[a];
            }
            return a - b;
        });

        TreeSet<Integer> miniSet = new TreeSet<>((a, b) -> {
            if (nums[a] != nums[b]) {
                return nums[a] - nums[b];
            }
            return a - b;
        });

        maxiSet.add(0);
        miniSet.add(0);

        long ans = 0;
        int ind = 0;
        for (int i = 0; i < nums.length; i++) {
            ind = remove(nums, ind, i, maxiSet, miniSet);
            ind = remove(nums, ind, i, miniSet, maxiSet);

            maxiSet.add(i);
            miniSet.add(i);
            ans += i - ind + 1;
        }
        return ans;
    }

    public int remove(int[] nums, int ind, int i, TreeSet<Integer> set, TreeSet<Integer> set2) {
        while (!set.isEmpty() && Math.abs(nums[set.first()] - nums[i]) > 2) {
            int temp = set.first();
            while (ind <= temp) {
                set.remove(ind);
                set2.remove(ind);
                ind++;
            }
        }
        return ind;
    }


    /*
        Optimized code below :
     */

    public long continuousSubarraysOptimized(int[] nums) {
        TreeSet<Integer> ts = new TreeSet<>((a, b) -> {
            if (nums[a] != nums[b]) {
                return nums[a] - nums[b];
            }
            return a - b;
        });
        long ans = 0;
        int ind = 0;

        for (int i = 0; i < nums.length; i++) {
            // Add the current index to the TreeSet
            ts.add(i);

            // Check the bounds and adjust the index pointer `ind`
            while (!ts.isEmpty() && (Math.abs(nums[ts.first()] - nums[i]) > 2 || Math.abs(nums[ts.last()] - nums[i]) > 2)) {
                ts.remove(ind++);
            }

            // Calculate the number of valid subarrays ending at index `i`
            ans += i - ind + 1;
        }
        return ans;
    }


    /*
        Further Optimization O(N) space
     */


}
