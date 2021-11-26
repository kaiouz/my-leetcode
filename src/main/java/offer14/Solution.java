package offer14;

class Solution {

    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        dp[1] = 1;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] * j);
                dp[i] = Math.max(dp[i], (i - j) * j);
            }
        }

        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(new Solution().cuttingRope(10));
    }
}
