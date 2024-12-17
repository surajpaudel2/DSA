import java.util.*;

public class Leetcode2981SpecialSubstring {
    public static void main(String[] args) {
        String str = "abcdaaefaaghaaad";
        int ans = new Leetcode2981SpecialSubstring().maximumLength(str);
        System.out.println(ans);
    }

    public int maximumLength(String s) {
        Map<Character, List<int[]>> map = new HashMap<Character, List<int[]>>();

        int p1 = 0, p2 = 1;
        while (p2 < s.length()) {
            if (s.charAt(p1) != s.charAt(p2)) {
                if (!map.containsKey(s.charAt(p1))) {
                    List<int[]> list = new ArrayList<>();
                    map.put(s.charAt(p1), list);
                }

                List<int[]> list = map.get(s.charAt(p1));
                int[] arr = {p1, p2};
                list.add(arr);
                p1 = p2;
            }
            p2++;
        }

        List<int[]> list = null;
        if(!map.containsKey(s.charAt(p1))) {
            list = new ArrayList<>();
            map.put(s.charAt(p1), list);
        } else {
            list = map.get(s.charAt(p1));
        }

        list.add(new int[] {p1, p2});

        int ans = -1;
        for(char i : map.keySet()) {
            List<int[]> li = map.get(i);

            Map<Integer, Integer> freq = new HashMap<>();
            for(int[] arr : li) {
                int actFreq = arr[1] - arr[0];
                for(int j = 1; j <= actFreq; j++) {
                    freq.put(j, freq.getOrDefault(j, 0) + ((actFreq - j) + 1));
                }
            }

            for(int j : freq.keySet()) {
                if(j > ans && freq.get(j) >= 3) {
                    ans = j;
                }
            }
        }
        return ans;
    }
}
