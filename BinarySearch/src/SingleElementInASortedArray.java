public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        // int low = 0, high = nums.length - 1;
        if (nums[0] != nums[1]) {
            return nums[0];
        }

        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            return nums[nums.length - 1];
        }

        int low = 1;
        int high = nums.length - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == nums[mid + 1]) {
                if (mid % 2 == 0) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] == nums[mid - 1]) {
                if (mid % 2 == 0) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }
        return -1;
    }
}
