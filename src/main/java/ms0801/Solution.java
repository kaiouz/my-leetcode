package ms0801;

class Solution {
    public static final int MOD = 1000000007;

    public int waysToChange(int n) {
        int[] cash = new int[]{1, 5, 10, 25};

        long[][] dp = new long[n + 1][cash.length];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < cash.length; j++) {
                if (cash[j] <= i) {
                    for (int k = 0; k <= j; k++) {
                        dp[i][j] += dp[i - cash[j]][k];
                    }
                }
            }
        }

        return (int) ((dp[n][0] + dp[n][1] + dp[n][2] + dp[n][3]) % MOD);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().waysToChange(10));
    }
}
