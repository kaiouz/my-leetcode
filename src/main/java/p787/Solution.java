package p787;

class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] dp = new int[k + 2][n + 1];
        int max = Integer.MAX_VALUE / 2;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = max;
            }
        }

        dp[0][src] = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int[] flight : flights) {
                dp[i][flight[1]] = Math.min(dp[i][flight[1]], dp[i-1][flight[0]] + flight[2]);
            }
        }

        int ans = max;
        for (int i = 0; i < dp.length; i++) {
            ans = Math.min(dp[i][dst], ans);
        }

        return ans == max ? - 1 : ans;
    }
}
