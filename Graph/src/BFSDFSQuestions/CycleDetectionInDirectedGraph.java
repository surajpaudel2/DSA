package BFSDFSQuestions;

import java.util.ArrayList;

public class CycleDetectionInDirectedGraph {
    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];

        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                if (dfs(adj, i, new boolean[adj.size()], visited)) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int V, boolean[] inRec, boolean[] visited) {
        if (inRec[V]) {
            return true;
        }

        if (visited[V]) {
            return false;
        }

        visited[V] = true;
        inRec[V] = true;

        for (int i : adj.get(V)) {
            boolean isCycle = dfs(adj, i, inRec, visited);
            if (isCycle) {
                return true;
            }
        }
        inRec[V] = false;
        return false;
    }
}