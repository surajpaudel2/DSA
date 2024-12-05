import java.util.ArrayList;
import java.util.List;

/*
    => Learned how to get idea to convert to the equations in programming
    => Always try to see the big picture, sometimes it can be really helpful, for example in this question :

        -> You are doing subtracting sum of an array and sum of first natural numbers at first, if you just
        see the result of those subtraction value you will just see the single value, and idea will not
        come to think in terms of the equations but if you see the whole process you will get to know.

        -> So after finding the one equation try to find other equations and try to solve by using maths.
 */

public class MissingAndRepeatingNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4};
        List<Integer> ans = new MissingAndRepeatingNumber().findTwoElement(arr);
        System.out.println(ans);
    }

    ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length;
        long nthSum = ((long) n * (n + 1)) / 2;
        long arrSum = 0;
        long nthSquaredSum = ((long) n * (n + 1) * (2L * n + 1)) / 6;
        long arrSquaredSum = 0;

        for(int i : arr) {
            arrSum += (long)i;
            arrSquaredSum += (long)i * i;
        }

//        Find equations
        long firstEq = arrSum - nthSum;  // x - y
        long squaredDiff = arrSquaredSum - nthSquaredSum; // x^2 - y^2
        long secondEq = squaredDiff / firstEq; // x + y

//        After doing some algebra i.e by adding x - y + x + y

        long x = (firstEq + secondEq) / 2;
        long y = secondEq - x;
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add((int)x);
        ans.add((int)y);
        return ans;
    }
}
