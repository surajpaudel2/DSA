package BFSDFSQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleDetectionInAnUndirectedGraph {
    public static void main(String[] args) {

    }

    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here

        boolean[] visited = new boolean[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                boolean b = byUsingBFS(i, adj, visited);
                if (b) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean byUsingBFS(int st, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(st);

        while (!q.isEmpty()) {
            int temp = q.poll();

            if (visited[temp]) {
                return true;
            }

            visited[temp] = true;

            for (int i : adj.get(temp)) {
                if (!visited[i]) {
                    q.offer(i);
                }
            }
        }

        return false;
    }

//    Cycle detection by using DFS

    public boolean dfs(int V, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        if (visited[V]) {
            return true;
        }

        visited[V] = true;

        boolean ans = false;
        List<Integer> temp = new ArrayList<>();
        for (int i : adj.get(V)) {
            if (!visited[i]) {
                temp.add(i);
            }
        }

        for (int i : temp) {
            ans = ans || dfs(i, adj, visited);
        }

        return ans;
    }

//    Optimize Cycle detection in DFS

    public boolean dfs(int v, int p, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        if (visited[v]) {
            return true;
        }

        visited[v] = true;

        for (int i : adj.get(v)) {
            if (i != p && v != i) {
                if (dfs(i, v, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
