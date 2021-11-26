package p877;

class Solution {

    public boolean stoneGame(int[] piles) {
        int[][][] dp = new int[piles.length][piles.length][2];
        for (int i = 0; i < piles.length; i++) {
            dp[i][i][0] = piles[i];
        }
        for (int len = 1; len < piles.length; len++) {
            for (int i = 0; i + len < piles.length; i++) {
                int j = i + len;
                dp[i][j][0] = piles[i] + dp[i + 1][j][1];
                dp[i][j][1] = dp[i + 1][j][0];
                int k = piles[j] + dp[i][j - 1][1];
                if (k > dp[i][j][0]) {
                    dp[i][j][0] = k;
                    dp[i][j][1] = dp[i][j - 1][0];
                }
            }
        }
        return dp[0][piles.length - 1][0] > dp[0][piles.length - 1][1];
    }

}
