public class FindAPeakElementII {
    public static void main(String[] args) {

    }

    public int[] findPeakGrid(int[][] mat) {
        if (mat.length == 1) {
            return new int[]{0, findMaxIndex(mat[0])};
        }

        if (mat[0].length == 1) {
            int ind = 0;
            for (int i = 1; i < mat.length; i++) {
                ind = mat[i][0] > mat[ind][0] ? i : ind;
            }

            return new int[]{ind, 0};
        }

        int low = 0, high = mat.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int maxIndOfRow = findMaxIndex(mat[mid]);

            if (mid == mat.length - 1 && mat[mid][maxIndOfRow] > mat[mid - 1][maxIndOfRow]) {
                return new int[]{mid, maxIndOfRow};

            } else if (mid == 0 && mat[mid][maxIndOfRow] > mat[mid + 1][maxIndOfRow]) {
                return new int[]{mid, maxIndOfRow};
            } else if (mat[mid][maxIndOfRow] < mat[mid - 1][maxIndOfRow]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }

    public int findMaxIndex(int[] arr) {
        int ind = 0;
        for (int i = 1; i < arr.length; i++) {
            ind = arr[ind] > arr[i] ? ind : i;
        }
        return ind;
    }
}
