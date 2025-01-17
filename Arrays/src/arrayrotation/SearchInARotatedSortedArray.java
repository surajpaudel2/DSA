package arrayrotation;

public class SearchInARotatedSortedArray {
    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }
//            Find in which half you are in. Are you in correct half?
            if (nums[mid] > nums[low] && nums[low] <= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
