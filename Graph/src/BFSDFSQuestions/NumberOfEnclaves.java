package BFSDFSQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 1, 1, 1, 0, 1, 0, 0},

                {1, 1, 0, 0, 0, 1, 0, 1, 1, 1},

                {0, 0, 0, 1, 1, 1, 0, 1, 0, 0},

                {0, 1, 1, 0, 0, 0, 1, 0, 1, 0},

                {0, 1, 1, 1, 1, 1, 0, 0, 1, 0},

                {0, 0, 1, 0, 1, 1, 1, 1, 0, 1},

                {0, 1, 1, 0, 0, 0, 1, 1, 1, 1},

                {0, 0, 1, 0, 0, 1, 0, 1, 0, 1},

                {1, 0, 1, 0, 1, 1, 0, 0, 0, 0},

                {0, 0, 0, 0, 1, 1, 0, 0, 0, 1}};

        int ans = new NumberOfEnclaves().numEnclaves(grid);
        System.out.println(ans);
    }

    class RowColPair {
        int row;
        int col;

        RowColPair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int numEnclaves(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;

        boundaryBFS(visited, grid);

        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[i].length - 1; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    public void boundaryBFS(boolean[][] visited, int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 1 && !visited[i][0]) {
                bfs(visited, grid, i, 0);
            }
            if (grid[i][grid[0].length - 1] == 1 && !visited[i][grid[0].length - 1]) {
                bfs(visited, grid, i, grid[0].length - 1);
            }
        }

        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == 1 && !visited[0][i]) {
                bfs(visited, grid, 0, i);
            }
            if (grid[grid.length - 1][i] == 1 && !visited[grid.length - 1][i]) {
                bfs(visited, grid, grid.length - 1,  i);
            }
        }
    }

    public void bfs(boolean[][] visited, int[][] grid, int row, int col) {
        Queue<RowColPair> q = new LinkedList<>();
        q.offer(new RowColPair(row, col));
        visited[row][col] = true;

        int[] rows = {0, 0, 1, -1};
        int[] cols = {1, -1, 0, 0};
        while (!q.isEmpty()) {
            RowColPair p = q.poll();
            row = p.row;
            col = p.col;

            for (int i = 0; i < 4; i++) {
                int x = row + rows[i];
                int y = col + cols[i];

                if (x >= 0 && x < grid.length && y >= 0 && y < grid[x].length && !visited[x][y] && grid[x][y] == 1) {
                    q.offer(new RowColPair(x, y));
                    visited[x][y] = true;
                }
            }
        }
    }
}
