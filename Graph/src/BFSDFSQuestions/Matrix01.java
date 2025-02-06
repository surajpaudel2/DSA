package BFSDFSQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
    class Pair {
        int row, col, ans;

        Pair(int row, int col, int ans) {
            this.row = row;
            this.col = col;
            this.ans = ans;
        }
    }

    //    This is not an optimized solution. It will take the time complexity of O(n * m) * O(n * m) = O(n * m) ^ 2
//    We are starting from BFS from 1 and for each 1 we are doing BFS which will take O(n * m) time.
    public int[][] updateMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] = bfs(i, j, mat);
                }
            }
        }
        return mat;
    }

    public int bfs(int row, int col, int[][] mat) {
        int[] cols = {0, 0, -1, 1};
        int[] rows = {-1, 1, 0, 0};

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(row, col, 0));
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        int ans = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int currRow = curr.row, currCol = curr.col, currAns = curr.ans;

            if (mat[currRow][currCol] == 0) {
                ans = Math.min(ans, currAns);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int x = currRow + rows[i];
                int y = currCol + cols[i];

                if (x >= 0 && x < mat.length && y >= 0 && y < mat[currRow].length && !visited[x][y]) {
                    q.offer(new Pair(x, y, currAns + 1));
                    visited[x][y] = true;
                }
            }
        }
        return ans;
    }

    //    Optimized solution

//    Write the intuition behind this below code in comments

    //    This is the optimized solution for the above problem. We will start from 0 and apply BFS to get the answer.
//    We will apply BFS from all the 0's and keep updating the result array with the distance from the nearest 0.
//    The time complexity of this code will be O(N * M) where N is the number of rows and M is the number of columns.

    public int[][] updateMatrixOptimized(int[][] mat) {
        int[][] result = new int[mat.length][mat[0].length];
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                result[i][j] = -1;
                if (mat[i][j] == 0) {
                    queue.offer(new Pair(i, j, -1));
                    visited[i][j] = true;
                }
            }
        }

        bfs(result, mat, visited, queue);
        return result;
    }

    public void bfs(int[][] result, int[][] mat, boolean[][] visited, Queue<Pair> queue) {
        int[] row = {0, 0, -1, 1};
        int[] col = {1, -1, 0, 0};

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int pRow = p.row, pCol = p.col, pAns = p.ans;
            int ans = pAns + 1;
            result[pRow][pCol] = ans;

            for (int i = 0; i < 4; i++) {
                int x = pRow + row[i];
                int y = pCol + col[i];

                if (x >= 0 && x < mat.length && y >= 0 && y < mat[x].length && !visited[x][y]) {
                    visited[x][y] = true;
                    queue.offer(new Pair(x, y, ans));
                }
            }
        }
    }
}
