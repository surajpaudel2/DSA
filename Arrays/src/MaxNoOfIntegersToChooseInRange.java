import java.util.HashSet;
import java.util.Set;

public class MaxNoOfIntegersToChooseInRange {
    public static void main(String[] args) {

    }

    public int maxCount(int[] banned, int n, int maxSum) {
        if (maxSum <= 1) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int i : banned) {
            set.add(i);
        }

        int count = 0, sum = 0;
        for (int i = 1; i <= n; i++) {
            if(!set.contains(i)) {
                sum += i;
                if(sum <= maxSum) {
                    count++;
                } else {
                    return count;
                }
            }
        }
        return count;
    }
}
