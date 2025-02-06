public class MedianOf2SortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        double ans = new MedianOf2SortedArrays().findMedianSortedArrays(nums1, nums2);
        System.out.println(ans);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if(m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int totalRequired = (m + n) / 2;

        int left = -1, right = m;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            int leftNums1 = Integer.MIN_VALUE;
            int leftNums2 = Integer.MIN_VALUE;
            int rightNums1 = Integer.MAX_VALUE;
            int rightNums2 = Integer.MAX_VALUE;

            if(mid > -1 && mid < m) {
                leftNums1 = nums1[mid];
            }
            if (mid + 1 < m) {
                rightNums1 = nums1[mid + 1];
            }

            int remaining = totalRequired - (mid + 1);
            if(remaining > 0) {
                leftNums2 = nums2[remaining - 1];
            }
            if(remaining < n) {
                rightNums2 = nums2[remaining];
            }

            if(leftNums1 > rightNums2) {
                right = mid - 1;
            } else if(leftNums2 > rightNums1) {
                left = mid + 1;
            } else {
                int leftMax = Math.max(leftNums1, leftNums2);
                int rightMin = Math.min(rightNums1, rightNums2);
                if((m + n) % 2 == 0) {
                    return ((double) leftMax + (double) rightMin) / (double) 2;
                } else {
                    return rightMin;
                }
            }
        }
        return -1;
    }
}
