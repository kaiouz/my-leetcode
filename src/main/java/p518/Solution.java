package p518;

class Solution {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().change(5,  new int[]{1, 2, 5}));
    }

}
