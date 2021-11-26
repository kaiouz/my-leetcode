package p343;

class Solution {

    public int integerBreak(int n) {
        if (n <= 2) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            for (int k = 1; k < i; k++) {
                dp[i] = Math.max(dp[i], k * (i - k));
                dp[i] = Math.max(dp[i], k * dp[i - k]);
            }
        }

        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(new Solution().integerBreak(10));
    }
}
