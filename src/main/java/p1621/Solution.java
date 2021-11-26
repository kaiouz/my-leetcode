package p1621;

import java.util.Arrays;

class Solution {
    public int numberOfSets(int n, int k) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        dp[0] = 0;

        for (int i = 2; i <= k; i++) {
            for (int j = n - 1; j >= k; j--) {
                for (int q = i; q < j; q++) {
                    dp[i] += dp[q];
                }
            }
        }

        return dp[n-1];
    }


    public static void main(String[] args) {
        System.out.println(new Solution().numberOfSets(4, 2));
    }

}
