package BFSDFSQuestions;

import java.util.*;

public class NumberOfIslandsII {
    public static void main(String[] args) {
        int[][] q = {{0, 0}, {0, 1}, {1, 2}, {2, 1}};
        int m = 3;
        int n = 3;
        int[] ans = numOfIslandsII(n, m, q);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] numOfIslandsII(int n, int m, int[][] q) {
        Set<String> set = new HashSet<String>();

        List<Integer> ans = new ArrayList<>();
        for (int[] arr : q) {
            set.add(arr[0] + "," + arr[1]);
            ans.add(bfs(set, n, m));
        }

        int[] results = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            results[i] = ans.get(i);
        }
        return results;
    }

    private static int bfs(Set<String> set, int n, int m) {
        Set<String> visited = new HashSet<String>();

        int[] rows = {0, 0, -1, 1};
        int[] cols = {-1, 1, 0, 0};
        int count = 0;
        for (String str : set) {
            if (!visited.contains(str)) {
                Queue<String> q = new LinkedList<>();
                q.offer(str);

                while (!q.isEmpty()) {
                    String[] currStr = q.poll().split(",");
                    int row = Integer.parseInt(currStr[0]);
                    int col = Integer.parseInt(currStr[1]);

                    for (int i = 0; i < 4; i++) {
                        int x = row + rows[i];
                        int y = col + cols[i];

                        String temp = x + "," + y;
                        if (x >= 0 && x < n && y >= 0 && y < m && !visited.contains(temp) && set.contains(temp)) {
                            q.offer(temp);
                            visited.add(temp);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
}
