package p44;

class Solution {

    public boolean isMatch(String s, String p) {
        int m = p.length() + 1;
        int n = s.length() + 1;

        boolean dp[][] = new boolean[m][n];
        dp[0][0] = true;

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (j == 0) {
                    dp[i][j] = p.charAt(i - 1) == '*' && dp[i - 1][j];
                } else {
                    char c = p.charAt(i - 1);
                    if (c == '*') {
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                    } else if (c == '?') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = c == s.charAt(j - 1) && dp[i - 1][j - 1];
                    }
                }

            }
        }

        return dp[m - 1][n - 1];
    }


    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("bbbbbbbabbaabbabbbbaaabbabbabaaabbababbbabbbabaaabaab",
                "b*b*ab**ba*b**b***bba"));
    }
}
