package BFSDFSQuestions;

public class NumberOfIslands {
    public static void main(String[] args) {

    }

    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(i, j, grid, visited);
                    count++;
                }
            }
        }
        return count;
    }

    int[] rows = {0, 0, -1, 1};
    int[] cols = {-1, 1, 0, 0};

    public void dfs(int row, int col, char[][] grid, boolean[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length ||
                visited[row][col] || grid[row][col] == '0') {
            return;
        }

        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            dfs(row + rows[i], col + cols[i], grid, visited);
        }
    }
}
