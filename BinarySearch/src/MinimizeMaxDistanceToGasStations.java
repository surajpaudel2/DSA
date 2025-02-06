import java.util.PriorityQueue;

public class MinimizeMaxDistanceToGasStations {
    public static void main(String[] args) {

    }

    public static double findSmallestMaxDist(int[] stations, int k) {
        int[] howMany = new int[stations.length - 1];
        for (int i = 0; i < k; i++) {
            int max = Integer.MIN_VALUE, ind = -1;
            for (int j = 1; j < stations.length; j++) {
                int temp = (stations[j] - stations[j - 1]) / howMany[j - 1] + 1;
                if (temp > max) {
                    max = temp;
                    ind = j - 1;
                }
            }
            howMany[ind]++;
        }

        double ans = Integer.MIN_VALUE;
        for (int i = 1; i < stations.length; i++) {
            double diff = ((double) stations[i] - (double) stations[i - 1]) / (double) (howMany[i - 1] + 1);

            ans = Math.max(ans, diff);
        }
        return ans;
    }

    public static double findSmallestMaxDistOptimized(int stations[], int k) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> {
            // Sort in descending order based on the second index (index 1)
            return Double.compare(b[0], a[0]); // b[1] - a[1] for descending order
        });

        int[] howMany = new int[stations.length - 1];

        for (int i = 0; i < stations.length - 1; i++) {
            pq.offer(new double[]{(double) (stations[i + 1] - stations[i]), (double)i});
        }


        for (int i = 0; i < k; i++) {
            double[] nums = pq.poll();
            int secInd = (int)nums[1];
            howMany[secInd]++;

            double temp = (stations[secInd + 1] - stations[secInd]) / (double) (howMany[secInd] + 1);

            pq.offer(new double[] {temp, secInd});
        }

        return pq.peek()[0];
    }
}
