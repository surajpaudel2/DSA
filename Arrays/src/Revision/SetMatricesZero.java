package Revision;

import java.util.Arrays;

public class SetMatricesZero {
    public static void main(String[] args) {
        int[][] nums = {{0, 1, 2, 0}, {3, 4, 5, 5}, {6, 7, 8, 9}};
        new SetMatricesZero().setZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }
    }

    public void setZeroes(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                }
            }
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = arr[0].length - 1; j >= 0; j--) {
                if (arr[i][0] == 0 || arr[0][j] == 0) {
                    arr[i][j] = 0;
                }
            }
        }
    }
}
