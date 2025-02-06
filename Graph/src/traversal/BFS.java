package traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[adj.size()];
        queue.add(0);
        visited[0] = true;

        ArrayList<Integer> res = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            res.add(u);
            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    queue.add(v);
                    visited[v] = true;
                }
            }
        }
        return res;
    }
}
