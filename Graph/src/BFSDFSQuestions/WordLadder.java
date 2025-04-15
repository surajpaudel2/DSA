package BFSDFSQuestions;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");
        String begin = "hit";
        String end = "cog";

        int ans = new WordLadder().ladderLength(begin, end, wordList);
        System.out.println(ans);
    }

    class WordResultPair {
        String currStr;
        int currRes;

        WordResultPair(String currStr, int currRes) {
            this.currStr = currStr;
            this.currRes = currRes;
        }
    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<String>();
        Set<String> wordsSet = new HashSet<>(wordList);

        // BFS

        int ans = Integer.MAX_VALUE;
        Queue<WordResultPair> q = new LinkedList<>();

        q.offer(new WordResultPair(beginWord, 0));

        while (!q.isEmpty()) {
            WordResultPair wrp = q.poll();
            if (wrp.currStr.equals(endWord)) {
                ans = Math.min(ans, wrp.currRes + 1);
                continue;
            }
            addCompatabibleWords(q, visited, wordsSet, wrp);
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public void addCompatabibleWords(Queue<WordResultPair> q, Set<String> visited, Set<String> wordSet, WordResultPair curr) {
        StringBuffer sb = new StringBuffer(curr.currStr);

        for (int i = 'a'; i <= 'z'; i++) {
            for (int j = 0; j < sb.length(); j++) {
                char ch = sb.charAt(j);
                sb.setCharAt(j, (char) i);
                String temp = sb.toString();
                if (wordSet.contains(temp) && !visited.contains(temp)) {
                    q.offer(new WordResultPair(temp, curr.currRes + 1));
                    visited.add(temp);
                }
                sb.setCharAt(j, ch);
            }
        }
    }
}

