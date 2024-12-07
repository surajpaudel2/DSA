public class MinimumLimitOfBallInABag {
    public static void main(String[] args) {
        int[] arr = {2, 4, 8, 2};
        int ans = new MinimumLimitOfBallInABag().minimumSize(arr, 4);
        System.out.println(ans);
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = Integer.MIN_VALUE;
        for(int i : nums) {
            right = Math.max(i, right);
        }

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(isPossible(nums, mid, maxOperations)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean isPossible(int[] nums, int size, int maxOperations) {
        int count = 0;
        for(int i : nums) {
            if(size < i) {
                int temp = i / size;
                if(i % size != 0) {
                    count += temp;
                } else {
                    count += temp - 1;
                }

                if(count > maxOperations) {
                    return false;
                }
            }
        }
        return true;
    }
}
