package p931;

class Solution {

    public int minFallingPathSum(int[][] A) {
        int m = A.length;
        int n = A[0].length;

        int[][] dp = new int[m][n];

        dp[0] = A[0];

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = dp[i-1][j] + A[i][j];
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + A[i][j]);
                }
                if (j < n - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j+1] + A[i][j]);
                }
            }
        }

        int max = Integer.MAX_VALUE;
        for (int num : dp[m - 1]) {
            max = Math.min(max, num);
        }

        return max;
    }


}
