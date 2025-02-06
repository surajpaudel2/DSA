package BFSDFSQuestions;

import java.util.LinkedList;
import java.util.Queue;

/*
    => Time complexity of this code will be O(N^2) because, outer loop runs for O(N) max and in dfs if we combine all
     the queue will run for O(N) max but the for loop inside the bfs will run for N times for each Vertex, which will
      result into O(N^2). So, to optimize this we have to convert into adjancency list

 */

public class NoOfProviences {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        for(int i = 0; i < isConnected.length; i++) {
            if(!visited[i]) {
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

    public void bfs(int[][] isConnected, boolean[] visited, int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = true;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for(int j = 0; j < isConnected[curr].length; j++) {
                if(isConnected[curr][j] == 1 && !visited[j]) {
                    queue.add(j);
                    visited[j] = true;
                }
            }
        }
    }

//    DFS Way
    public void dfs(int[][] isConnected, boolean[] visited, int i) {
        visited[i] = true;

        for(int j = 0; j < isConnected[i].length; j++) {
            if(isConnected[i][j] == 1 && !visited[j]) {
                dfs(isConnected, visited, j);
            }
        }
    }
}
