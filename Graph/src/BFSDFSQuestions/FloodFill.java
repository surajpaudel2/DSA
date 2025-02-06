package BFSDFSQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//        Perform BFS.
        class Pair {
            Pair(int row, int col) {
                this.row = row;
                this.col = col;
            }

            int row, col;
        }

        Pair pair = new Pair(sr, sc);

        Queue<Pair> q = new LinkedList<>();
        q.offer(pair);

        boolean[][] visited = new boolean[image.length][image[0].length];
        visited[sr][sc] = true;
        int x = image[sr][sc];

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            image[curr.row][curr.col] = color;

            if (curr.row + 1 < image.length && image[curr.row + 1][curr.col] == x && !visited[curr.row + 1][curr.col]) {
                q.add(new Pair(curr.row + 1, curr.col));
                visited[curr.row + 1][curr.col] = true;
            }
            if (curr.row - 1 >= 0 && image[curr.row - 1][curr.col] == x && !visited[curr.row - 1][curr.col]) {
                q.add(new Pair(curr.row - 1, curr.col));
                visited[curr.row - 1][curr.col] = true;
            }
            if (curr.col + 1 < image[0].length && image[curr.row][curr.col
                    + 1] == x && !visited[curr.row][curr.col + 1]) {
                q.add(new Pair(curr.row, curr.col + 1));
                visited[curr.row][curr.col + 1] = true;
            }
            if (curr.col - 1 >= 0 && image[curr.row][curr.col - 1] == x && !visited[curr.row][curr.col - 1]) {
                q.add(new Pair(curr.row, curr.col - 1));
                visited[curr.row][curr.col - 1] = true;
            }
        }
        return image;
    }

}
