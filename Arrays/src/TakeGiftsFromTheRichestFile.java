import java.util.Collections;
import java.util.PriorityQueue;

public class TakeGiftsFromTheRichestFile {
    public static void main(String[] args) {
        int[] arr = {25, 64, 9, 4, 100};
        long ans = new TakeGiftsFromTheRichestFile().pickGifts(arr, 4);
        System.out.println(ans);
    }

    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : gifts) {
            pq.offer(i);
        }

        for(int i = 0; i < k; i++) {
            int top = pq.poll();
            pq.offer((int) Math.sqrt(top));
        }

        long sum = 0;
        while(!pq.isEmpty()) {
            sum += pq.poll();
        }
        return sum;
    }
}
