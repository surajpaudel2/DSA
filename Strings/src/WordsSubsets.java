import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordsSubsets {
    public static void main(String[] args) {

    }

    public List<String> wordSubsets(String[] words1, String[] words2) {
        Map<Character, Integer> words2Count = new HashMap<>();
        for (int i = 0; i < words2.length; i++) {
            Map<Character, Integer> map = new HashMap<>();
            String word = words2[i];
            for (int j = 0; j < word.length(); j++) {
                map.put(word.charAt(j), map.getOrDefault(word.charAt(j), 0) + 1);

                if(words2Count.containsKey(word.charAt(j))) {
                    words2Count.put(word.charAt(j), Math.max(words2Count.get(word.charAt(j)), map.get(word.charAt(j))));
                } else {
                    words2Count.put(word.charAt(j), 1);
                }
            }
        }

        List<String> result = new ArrayList<>();
        for (String word : words1) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < word.length(); i++) {
                map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0) + 1);
            }
            boolean b = true;
            for (char c : words2Count.keySet()) {
                if(!map.containsKey(c) || map.get(c) < words2Count.get(c)) {
                    b = false;
                    break;
                }
            }
            if (b) {
                result.add(word);
            }
        }

        
        return result;
    }
}
