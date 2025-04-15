package BFSDFSQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0) {
                if (!bfs(i, visited, graph)) {
                    return false;
                }
            }
        }
        return true;
    }

    class Pair {
        int ind;
        int num;

        Pair(int ind, int num) {
            this.ind = ind;
            this.num = num;
        }
    }

    public boolean bfs(int ind, int[] visited, int[][] graph) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(ind, 1));
        visited[ind] = 1;

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            int[] arr = graph[curr.ind];
            int num = curr.num == 1 ? 2 : 1;

            for (int i : arr) {
                if (visited[i] == 0) {
                    queue.offer(new Pair(i, num));
                    visited[i] = num;
                } else if (visited[i] == curr.num) {
                    return false;
                }
            }
        }
        return true;
    }
}
