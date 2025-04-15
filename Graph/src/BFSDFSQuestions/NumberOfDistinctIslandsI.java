package BFSDFSQuestions;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslandsI {
    public static void main(String[] args) {
//        int[][] grid = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
//        int[][] grid = {{1}};

        int[][] grid = {{1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 1}};
        int ans = new NumberOfDistinctIslandsI().countDistinctIslands(grid);
        System.out.println(ans);
    }

    int countDistinctIslands(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Set<String> distinctIslands = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    StringBuffer sb = new StringBuffer();
                    dfs(i, j, grid, visited, new int[]{i, j}, sb);

                    String str = sb.toString();
                    if (!str.isEmpty()) {
                        distinctIslands.add(sb.toString());
                    }
                }
            }
        }
        return distinctIslands.size();
    }

    int[] rows = {0, 0, 1, -1};
    int[] cols = {1, -1, 0, 0};

    public void dfs(int row, int col, int[][] grid, boolean[][] visited, int[] base, StringBuffer sb) {
        visited[row][col] = true;
        sb.append("{" + (row - base[0]) + ", " + (col - base[1]) + "}");

        for (int i = 0; i < 4; i++) {
            int x = rows[i] + row;
            int y = cols[i] + col;

            if (x < grid.length && x >= 0 && y < grid[row].length && y >= 0 && grid[x][y] == 1 && !visited[x][y]) {
                dfs(x, y, grid, visited, base, sb);
            }
        }
    }
}
