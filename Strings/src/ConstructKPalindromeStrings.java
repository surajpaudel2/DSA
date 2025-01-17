import java.util.HashMap;
import java.util.Map;

public class ConstructKPalindromeStrings {
    public static void main(String[] args) {
        String str = "annabelleefee";
        boolean ans = new ConstructKPalindromeStrings().canConstruct(str, 2);
        System.out.println(ans);
    }

    public boolean canConstruct(String s, int k) {
        if (k > s.length()) {
            return false;
        }
        if (k == s.length()) {
            return true;
        }

        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        }

        int count = 0;
        for (char ch : freq.keySet()) {
            if (freq.get(ch) % 2 != 0) {
                count++;
            }
            if (count > k) {
                return false;
            }
        }
        return true;
    }

    //    Optimized Code :
    public boolean canConstructOptimized(String s, int k) {
        if (k > s.length()) {
            return false;
        }
        if (k == s.length()) {
            return true;
        }

        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(freq[s.charAt(i) - 'a'] % 2 != 0) {
                count++;
                freq[s.charAt(i) - 'a'] = 0;
            }
            if(count > k) {
                return false;
            }
        }
        return true;
    }

}
