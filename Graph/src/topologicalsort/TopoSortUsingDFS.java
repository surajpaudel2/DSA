package topologicalsort;

import java.util.*;

public class TopoSortUsingDFS {
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                dfs(st, adj, visited, i);
            }
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        while (!st.isEmpty()) {
            result.add(st.pop());
        }

        return result;
    }

    public static void dfs(Stack<Integer> st, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int V) {
        visited[V] = true;

        for (int i : adj.get(V)) {
            if (!visited[i]) {
                dfs(st, adj, visited, i);
            }
        }

        st.push(V);
    }
}
