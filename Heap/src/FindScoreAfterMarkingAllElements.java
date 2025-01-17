import java.util.PriorityQueue;

public class FindScoreAfterMarkingAllElements {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 1, 3, 2};
        long ans = new FindScoreAfterMarkingAllElements().findScore(nums);
        System.out.println(ans);
    }

    public long findScore(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> {
            if (nums[i] != nums[j]) {
                return Integer.compare(nums[i], nums[j]);
            }
            return Integer.compare(i, j);
        });

        for (int i = 0; i < nums.length; i++) {
            pq.offer(i);
        }

        long ans = 0;
        while(!pq.isEmpty()) {
            int index = pq.poll();
            if(nums[index] == -1) {
                continue;
            }

            if(index < nums.length - 1) {
                nums[index + 1] = -1;
            }
            if (index > 0) {
                nums[index - 1] = -1;
            }
            ans += nums[index];
            nums[index] = -1;
        }

        return ans;
    }
}
