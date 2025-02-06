public class MinimumCostToMakeAtLeastOneValidPath {
    public static void main(String[] args) {

    }

    public int minCost(int[][] grid) {
//    1 = j + 1, 2 = j - 1, 3 = i + 1, 4 = i - 1
        return minCost(0, 0, grid);
    }

    public int minCost(int row, int col, int[][] grid) {
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return 0;
        }

        if (row == grid.length || col == grid[0].length || grid[row][col] == -1) {
            return Integer.MAX_VALUE;
        }

        int originalValue = grid[row][col];

        grid[row][col] = -1;
        int ans = Integer.MAX_VALUE;
        if (originalValue == 1) {
            ans = Math.min(ans, minCost(row, col + 1, grid));
        } else if (originalValue == 2) {
            ans = Math.min(ans, minCost(row, col - 1, grid));
        } else if (originalValue == 3) {
            ans = Math.min(ans, minCost(row + 1, col, grid));
        } else if (originalValue == 4) {
            ans = Math.min(ans, minCost(row - 1, col, grid));
        }

        ans = Math.min(ans, minCost(row + 1, col, grid)) + 1;
        ans = Math.min(ans, minCost(row - 1, col, grid)) + 1;
        ans = Math.min(ans, minCost(row, col + 1, grid)) + 1;
        ans = Math.min(ans, minCost(row, col - 1, grid)) + 1;

        grid[row][col] = originalValue;

        return ans;
    }

}
