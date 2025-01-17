import java.util.Arrays;

class ReversePairs {

    public int reversePairs(int[] nums) {
        if (nums.length <= 1) {
            return 0; // Base case: No reverse pairs in an array with 1 or fewer elements.
        }

        // Split the array into two halves
        int mid = nums.length / 2;
        int[] left = Arrays.copyOfRange(nums, 0, mid);   // Left subarray
        int[] right = Arrays.copyOfRange(nums, mid, nums.length); // Right subarray

        // Recursively find reverse pairs in left, right, and across both halves
        int countLeft = reversePairs(left);   // Count reverse pairs in left half
        int countRight = reversePairs(right); // Count reverse pairs in right half
        int countAcross = mergeAndCount(left, right, nums); // Count cross reverse pairs

        return countLeft + countRight + countAcross; // Total reverse pairs
    }

    public int mergeAndCount(int[] left, int[] right, int[] merged) {
        int i = 0, j = 0, k = 0, count = 0;

        // Reason for the Logic:
        /*
         - The goal is to count pairs where left[i] > 2 * right[j].
         - Since 'left' and 'right' are **sorted**, this allows optimization:
           1. If left[i] > 2 * right[j], then all remaining elements in 'left' (from i onwards)
              will also satisfy this condition because the elements in 'left' are larger as we move right.
           2. Thus, we can count all remaining elements in 'left' at once for the current 'right[j]'.
           3. If left[i] <= 2 * right[j], we increment i (move in left) to find a larger element.
        */

        // Count reverse pairs
        while (i < left.length && j < right.length) {
            if (left[i] > 2L * right[j]) {
                // Reason:
                // If left[i] > 2 * right[j], all elements from left[i] to left[end] satisfy the condition.
                // So, add (left.length - i) to the count and move j to the next element in 'right'.
                count += left.length - i;
                j++; // Increment right pointer to check the next 'right[j]'.
            } else {
                // If the condition is not satisfied, increment 'i' to check the next element in 'left'.
                i++;
            }
        }

        // Standard merge operation to combine 'left' and 'right' into 'merged'
        i = 0;
        j = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                merged[k++] = left[i++];
            } else {
                merged[k++] = right[j++];
            }
        }
        while (i < left.length) {
            merged[k++] = left[i++];
        }
        while (j < right.length) {
            merged[k++] = right[j++];
        }

        return count; // Return the count of reverse pairs
    }

    public static void main(String[] args) {
        ReversePairs rp = new ReversePairs();
        int[] nums = {1, 3, 2, 3, 1};
        System.out.println("Number of reverse pairs: " + rp.reversePairs(nums));
    }
}
