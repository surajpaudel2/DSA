import java.util.*;

public class MinOperationsNeededToMakeBTSorted {
    public static void main(String[] args) {

    }

    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int ans = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            List<Integer> li = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();

            int ind = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    pq.add(node.left.val);
                    li.add(node.left.val);
                    queue.add(node.left);
                    map.put(node.left.val, ind++);
                }
                if (node.right != null) {
                    pq.add(node.right.val);
                    li.add(node.right.val);
                    queue.add(node.right);
                    map.put(node.right.val, ind++);
                }
            }

            for (int i = 0; i < li.size(); i++) {
                int val = pq.poll();
                if (val != li.get(i)) {
                    ans++;

                    int temp1 = map.get(li.get(i));
                    int temp2 = map.get(val);

                    map.put(li.get(i), temp2);
                    map.put(val, temp1);

                    li.set(temp2, li.get(i));
                    li.set(temp1, val);
                }
            }
        }
        return ans;
    }
}
