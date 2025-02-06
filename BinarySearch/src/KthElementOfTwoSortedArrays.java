public class KthElementOfTwoSortedArrays {
    public static void main(String[] args) {

    }

    public int kthElement(int a[], int b[], int k) {
        int m = a.length;
        int n = b.length;
        if (m > n) {
            return kthElement(b, a, k);
        }

        int left = 0, right = Math.min(k, a.length);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            int mid2 = k - mid;

//            Very very important test case. If we just skip this if statement we will get the wrong answer, because while checking the condition will always be true to find the answer at last. i.e ,
            /*
                if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
               }
               The above if statement will produce true always if we don't write the below condition.
             */
            if (mid2 > n) {
                left = mid + 1;
                continue;
            }

            if (mid > 0) {
                l1 = a[mid - 1];
            }
            if (mid < m) {
                r1 = a[mid];
            }
            if (mid2 > 0 && mid2 <= n) {
                l2 = b[mid2 - 1];
            }
            if (mid2 >= 0 && mid2 < n) {
                r2 = b[mid2];
            }

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
