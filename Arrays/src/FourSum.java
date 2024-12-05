import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        while (i < nums.length - 3) {
            int j = i + 1;
            while (j < nums.length - 2) {
                int p1 = j + 1, p2 = nums.length - 1;

                while (p1 < p2) {
                    long sum = (long) nums[i] + (long) nums[j] + (long) nums[p1] + (long) nums[p2];
                    if (sum == (long) target) {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[p1], nums[p2]);
                        result.add(list);
                        int temp = nums[p1];
                        while (p1 < nums.length && temp == nums[p1]) {
                            p1++;
                        }
                        temp = nums[p2];
                        while (p2 > 0 && temp == nums[p2]) {
                            p2--;
                        }
                    } else if (sum < (long) target) {
                        int currElement = nums[p1];
                        while (p1 < nums.length && currElement == nums[p1]) {
                            p1++;
                        }
                    } else {
                        int currElement = nums[p2];
                        while (p2 > 0 && nums[p2] == currElement) {
                            p2--;
                        }
                    }
                }

                int currElement = nums[j];
                while (j < nums.length && nums[j] == currElement) {
                    j++;
                }
            }
            int currElement = nums[i];
            while (i < nums.length && nums[i] == currElement) {
                i++;
            }
        }
        return result;
    }
}
