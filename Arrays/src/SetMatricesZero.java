//Link : https://leetcode.com/problems/set-matrix-zeroes/

public class SetMatricesZero {
    public static void main(String[] args) {

    }

/*
    => This approach takes the O(N) space complexity .
 */
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


/*
    => Better approach with O(1) Space complexity.
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        int col = 1;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    if(j == 0) {
                        col = 0;
                    } else {
                        matrix[0][j] = 0;
                    }

                    matrix[i][0] = 0;
                }
            }
        }

        for(int i = matrix.length - 1; i >= 0; i--) {
            for(int j = matrix[i].length - 1; j >= 0; j--) {
                if (matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
                if(j == 0 && col == 0) {
                    matrix[i][j] = 0;
                }
                if(j != 0 && matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }

            }
        }
    }
}

}
