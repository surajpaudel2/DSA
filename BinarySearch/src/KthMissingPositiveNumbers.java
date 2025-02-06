public class KthMissingPositiveNumbers {
    public int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
//            Find how many missing numbers are present.
            if (arr[mid] - (mid + 1) >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (right < 0) {
            return k;
        }

        return (k - (arr[right] - (right + 1))) + arr[right];
    }
}
