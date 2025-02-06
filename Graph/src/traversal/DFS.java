package traversal;

import java.util.ArrayList;

public class DFS {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        if (adj == null || adj.isEmpty()) {
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];

        DFS(0, adj, res, visited);

        return res;
    }

    public void DFS(int curr, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans, boolean[] visited) {
        ans.add(curr);
        visited[curr] = true;

        for (int i : adj.get(curr)) {
            if (!visited[i]) {
                DFS(i, adj, ans, visited);
            }
        }
    }
}
