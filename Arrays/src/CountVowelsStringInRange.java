import java.util.*;

public class CountVowelsStringInRange {
    public static void main(String[] args) {
        String[] words = {"aba", "bcb", "ece", "aa", "e"};
        int[][] queries = {{0, 2}, {1, 4}, {1, 1}};
        int[] ans = new CountVowelsStringInRange().vowelStrings(words, queries);
        System.out.println(Arrays.toString(ans));
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        Map<Integer, Integer> vowelCount = new HashMap<>();
        vowelCount.put(-1, 0);

        Set<Character> vowels = getVowels();

        int count = 0;
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            if(vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length() - 1))) {
                count++;
            }
            vowelCount.put(i, count);
        }

        int[] result = new int[queries.length];

        for(int i = 0; i < queries.length; i++) {
            int[] query = queries[i];

            result[i] = vowelCount.get(query[1]) - vowelCount.get(query[0] - 1);
        }
        return result;
    }

    public Set<Character> getVowels() {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        return vowels;
    }
}
