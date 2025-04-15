import java.util.Arrays;

public class FindNextPermutation {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 3};
        new FindNextPermutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;

        int pivot = n - 1;

        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                pivot = i - 1;
                break;
            }
        }
        swapWithRightMostSuccessor(nums, pivot);

        reverseArray(pivot + 1, n - 1, nums);


    }

    public void swapWithRightMostSuccessor(int[] nums, int pivotInd) {
        int pivotNum = nums[pivotInd];
        int curr = pivotInd + 1;
        int initialInd = curr;

        while (curr < nums.length) {
            if (nums[curr] > pivotNum && nums[curr] <= nums[initialInd]) {
                initialInd = curr;
            }
            curr++;
        }

        int temp = nums[pivotInd];
        nums[pivotInd] = nums[initialInd];
        nums[initialInd] = temp;

    }

    public void reverseArray(int st, int end, int[] nums) {
        while (st < end) {
            int temp = nums[st];
            nums[st] = nums[end];
            nums[end] = temp;
            st++;
            end--;
        }
    }

}
