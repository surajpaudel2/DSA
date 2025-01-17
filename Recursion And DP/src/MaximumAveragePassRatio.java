//Link : https://leetcode.com/problems/maximum-average-pass-ratio/

public class MaximumAveragePassRatio {
    public static void main(String[] args) {
        int[][] classes = {{1,2}, {3, 5}, {2, 2}};
        int extraStudents = 2;

        double ans = new MaximumAveragePassRatio().maxAverageRatio(classes, extraStudents);
        System.out.println(ans);
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        return maxAverageRatio(classes, extraStudents, 0);
    }

    public double maxAverageRatio(int[][] classes, int extraStudents, int ind) {
        if (extraStudents == 0 || ind >= classes.length) {
            return calcAverage(classes);
        }

        double ans = 0;
        for (int i = ind; i < classes.length; i++) {
            classes[i][0]++;
            classes[i][1]++;
            double sp = maxAverageRatio(classes, extraStudents - 1, i);
            classes[i][0]--;
            classes[i][1]--;
            ans = Math.max(ans, sp);
        }
        return ans;
    }

    public double calcAverage(int[][] classes) {
        double ans = 0;
        for(int i = 0; i < classes.length; i++) {
            ans += (double) classes[i][0] / classes[i][1];
        }
        return ans / classes.length;
    }
}
