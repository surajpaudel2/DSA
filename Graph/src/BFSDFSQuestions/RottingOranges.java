package BFSDFSQuestions;

import java.lang.reflect.Array;
import java.util.*;

public class RottingOranges {
    class Pair {
        int row, col, ans;

        Pair(int row, int col, int ans) {
            this.row = row;
            this.col = col;
            this.ans = ans;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        int ans = 0;
        while (!q.isEmpty()) {
            Pair temp = q.poll();
            int row = temp.row;
            int col = temp.col;
            int tempAns = temp.ans;
            ans = Math.max(ans, tempAns);

            if (row + 1 < grid.length && !visited[row + 1][col] && grid[row + 1][col] == 1) {
                q.offer(new Pair(row + 1, col, tempAns + 1));
                visited[row + 1][col] = true;
                grid[row + 1][col] = 2;
            }
            if (row - 1 >= 0 && !visited[row - 1][col] && grid[row - 1][col] == 1) {
                q.offer(new Pair(row - 1, col, tempAns + 1));
                visited[row - 1][col] = true;
                grid[row - 1][col] = 2;
            }
            if (col + 1 < grid[row].length && !visited[row][col + 1] && grid[row][col + 1] == 1) {
                q.offer(new Pair(row, col + 1, tempAns + 1));
                visited[row][col + 1] = true;
                grid[row][col + 1] = 2;
            }
            if (col - 1 >= 0 && !visited[row][col - 1] && grid[row][col - 1] == 1) {
                q.offer(new Pair(row, col - 1, tempAns + 1));
                visited[row][col - 1] = true;
                grid[row][col - 1] = 2;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }
}