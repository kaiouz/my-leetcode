package p524;

import java.util.Arrays;
import java.util.List;

class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        int m = s.length();

        int[][] dp = new int[m+1][26];
        Arrays.fill(dp[m], -1);
        for (int i = m - 1; i >= 0; i--) {
            char mc = s.charAt(i);
            for (char c = 0 ; c < 26; c++) {
                if (mc == (c + 'a')) {
                    dp[i][c] = i;
                } else {
                    dp[i][c] =  dp[i+1][c];
                }
            }
        }

        String ans = "";

        for (String d : dictionary) {
            int j = 0;
            boolean match = true;
            for (int i = 0; i < d.length(); i++) {
                int k = d.charAt(i) - 'a';
                if (dp[j][k] == -1) {
                    match = false;
                    break;
                }
                j = dp[j][k];
            }
            if (match) {
                if (d.length() > ans.length() || (d.length() == ans.length() && d.compareTo(ans) < 0)) {
                    ans = d;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findLongestWord("abpcplea",
                Arrays.asList("ale","apple","monkey","plea")));
    }
}
