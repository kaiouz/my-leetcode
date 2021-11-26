package p322;

class Solution {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int c : coins) {
                if (c <= i && dp[i - c] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - c] + 1);
                }
            }
            if (dp[i] == Integer.MAX_VALUE) {
                dp[i] = -1;
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().coinChange(new int[]{2}, 3));
    }
}
