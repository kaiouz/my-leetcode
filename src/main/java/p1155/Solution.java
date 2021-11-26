package p1155;

class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        int mod = 1_000_000_007;

        int[][] dp = new int[d][target + 1];

        for (int i = 1; i <= f && i <= target; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < d; i++) {
            for (int j = i; j <= target; j++) {
                for (int k = 1; k <= f && k < j; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % mod;
                }
            }
        }

        return dp[d - 1][target];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numRollsToTarget(30, 30, 500));
    }
}
