import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CheckIfStringsCanBeValid {
    public static void main(String[] args) {

    }

    public boolean canBeValid(String s, String locked) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> li = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if(locked.charAt(i) == '1') {
                if(!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            } else {
                li.add(i);
            }
        }



        return stack.isEmpty();
    }
}
