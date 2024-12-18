import java.util.Arrays;
import java.util.Stack;

public class FindPricesWithSpecialDiscount {
    public static void main(String[] args) {
        int[] arr = {8, 4, 6, 2, 3};
        int[] ans = new FindPricesWithSpecialDiscount().finalPricesOptimized(arr);
        System.out.println(Arrays.toString(ans));
    }

    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] nxtSmall = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                nxtSmall[stack.pop()] = i;
            }
            stack.push(i);
        }

        for (int i = 0; i < prices.length; i++) {
            if (nxtSmall[i] != 0) {
                prices[i] = prices[i] - prices[nxtSmall[i]];
            }
        }
        return prices;
    }


    //    Optimized Solution:
    public int[] finalPricesOptimized(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                prices[stack.peek()] = prices[stack.pop()] - prices[i];
            }
            stack.push(i);
        }
        return prices;
    }
}
