package Revision;

public class RotateImage {
    public void inverse(int[][] matrix) {
        int st = 0;

        while (st < matrix.length) {
            int i = st;

            while (i < matrix.length) {
                swap(i, st, matrix);
                i++;
            }
            st++;
        }
    }

    public void swap(int i, int st, int[][] matrix) {
        int temp = matrix[i][st];
        matrix[i][st] = matrix[st][i];
        matrix[st][i] = temp;
    }

    public void reverse(int[][] matrix) {
        for (int[] arr : matrix) {
            reverseArray(arr);
        }
    }

    public void reverseArray(int[] arr) {
        int i = 0, j = arr.length - 1;

        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
