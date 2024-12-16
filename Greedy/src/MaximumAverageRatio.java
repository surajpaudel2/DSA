import java.util.PriorityQueue;

public class MaximumAverageRatio {
    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {3, 5}, {2, 2}};
        double ans = new MaximumAverageRatio().maxAverageRatio(arr, 2);
        System.out.println(ans);
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            // Calculate current and modified values for both arrays
            double currentA = (double) a[0] / a[1];
            double modifiedA = (double) (a[0] + 1) / (a[1] + 1);
            double diffA = modifiedA - currentA;

            double currentB = (double) b[0] / b[1];
            double modifiedB = (double) (b[0] + 1) / (b[1] + 1);
            double diffB = modifiedB - currentB;

            // Sort based on the maximum difference (descending order for max heap)
            return Double.compare(diffB, diffA);
        });

        for(int[] arr : classes) {
            pq.offer(arr);
        }

        double ans = 0;
        for(int i = 0; i < extraStudents; i++) {
            int[] arr = pq.poll();
            arr[0] = arr[0] + 1;
            arr[1] = arr[1] + 1;
            pq.offer(arr);
        }

        for(int i = 0; i < classes.length; i++) {
            int[] arr = pq.poll();
            ans += (double) arr[0] / arr[1];
        }

        return ans / classes.length;
    }
}
