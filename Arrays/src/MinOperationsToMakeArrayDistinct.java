import java.util.HashSet;
import java.util.Set;

public class MinOperationsToMakeArrayDistinct {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 2, 3, 3, 4};
//        int k = 2;
//        int[] arr = {4, 4, 4, 4};
//        int k = 1;

        int[] arr = {1, 4, 3, 2, 2, 100, 200};
        int ans = new MinOperationsToMakeArrayDistinct().minimumOperations(arr);
        System.out.println(ans);
    }

    public int minimumOperations(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();

        int i = 0, ans = 0;
        for (int j = 0; j < n; j++) {
            if (set.contains(nums[j])) {
                int count = 0;
                while (i < j) {
                    set.remove(nums[i]);
                    if (nums[i] == nums[j]) {
                        i++;
                        count++;
                        break;
                    }
                    i++;
                    count++;
                }
                if (count % 3 == 1) {
                    count += 2;
                    if (i < j) {
                        set.remove(nums[i]);
                    }
                    if (i + 1 < j) {
                        set.remove(nums[i + 1]);
                    }
                    i += 2;
                } else if (count % 3 == 2) {
                    count += 1;
                    if (i < j) {
                        set.remove(nums[i]);
                    }
                    i++;
                }
                ans += (count / 3);
                if (i > j) {
                    j = i;
                }
            }
            if (j < n) {
                set.add(nums[j]);
            }
        }
        return ans;
    }
}
