//Link : https://leetcode.com/problems/set-matrix-zeroes/

public class SetMatricesZero {
    public static void main(String[] args) {

    }

    public void setZeroes(int[][] matrix) {
        int[] horizontal = new int[matrix.length];

        for(int i = matrix.length - 1; i >= 0; i--) {
            for(int j = matrix[i].length - 1; j >= 0; j--) {
                if(matrix[i][j] == 0) {
                    matrix[matrix.length - 1][j] = 0;
                    horizontal[i] = -1;
                }
            }
        }

       for(int i = 0; i < matrix.length; i++) {
           for(int j = 0; j < matrix[i].length; j++) {
               if(matrix[matrix.length - 1][j] == 0 || horizontal[i] == -1) {
                   matrix[i][j] = 0;
               }
           }
       }
    }
}
