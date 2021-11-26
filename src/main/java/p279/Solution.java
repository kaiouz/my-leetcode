package p279;

class Solution {
    public int numSquares(int n) {
        int m = (int) Math.sqrt(n);

        int[] dp = new int[n+1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = i*i; j <= n; j++) {
                dp[j] = Math.min(dp[j-i*i]+1, dp[j]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(12));
    }
}
