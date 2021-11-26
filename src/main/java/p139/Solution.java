package p139;

import java.util.Arrays;
import java.util.List;

class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        Word word = new Word();
        for (String w : wordDict) {
            word.add(w, w.length() - 1);
        }

        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            Word w  = word;
            for (int j = i; j >= 0; j--) {
                int ci = s.charAt(j) - 'a';
                if (w.words != null && w.words[ci] != null) {
                    w = w.words[ci];
                    if (w.end) {
                        if (dp[i+1] = dp[j]) {
                            break;
                        }
                    }
                } else {
                    break;
                }
            }
        }

        return dp[s.length()];
    }


    static class Word {
        boolean end;
        Word[] words;

        public void add(String word, int index) {
            if (index >= 0) {
                if (words == null) {
                    words = new Word[26];
                }
                int i = word.charAt(index) - 'a';
                if (words[i] == null) {
                    words[i] = new Word();
                }
                words[i].add(word, index - 1);
            } else {
                end = true;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wordBreak("leetcode",
        Arrays.asList("leet","code")));
    }
}
