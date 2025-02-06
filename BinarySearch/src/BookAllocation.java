import java.util.ArrayList;

public class BookAllocation {
    public static void main(String[] args) {

    }

    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        if(m > n) {
            return -1;
        }

        int left = Integer.MIN_VALUE, right = 0;

        for (int i : arr) {
            left = Math.max(left, i);
            right += i;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossibleToAssign(arr, mid, n, m)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean isPossibleToAssign(ArrayList<Integer> arr, int mid, int n, int m) {
        int temp = 0;
        for (int i : arr) {
            if (m == 0) {
                return false;
            }
            temp += i;
            if (temp == mid) {
                m--;
                temp = 0;
            } else if (temp > mid) {
                m--;
                temp = i;
                if (m == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
