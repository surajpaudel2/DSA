import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumBeautyOfAnArray {
    public static void main(String[] args) {

    }

    public int maximumBeauty(int[] nums, int k) {
        int[][] range = new int[nums.length][2];

        for(int i = 0; i < nums.length; i++) {
            range[i] = new int[]{nums[i] - k, nums[i] + k};
        }

        Arrays.sort(range, Comparator.comparingInt(a -> a[0]));

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(range[0]);
        int max = 1;

        for(int i = 1; i < range.length; i++) {
           while(!queue.isEmpty() && queue.peek()[1] < range[i][0]) {
                queue.poll();
           }
           queue.offer(range[i]);
           max = Math.max(max, queue.size());
        }
        return max;
    }
}
