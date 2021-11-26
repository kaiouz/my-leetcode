package p1314;

import java.util.Arrays;

class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] dp = new int[m+1][n+1];

        for (int i =1; i <= m; i++) {
            for (int j=1; j <= n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + mat[i-1][j-1];
            }
        }

        int[][] answer = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x0 = Math.max(0, i - K);
                int x1 = Math.min(m-1, i+K);
                int y0 = Math.max(0, j - K);
                int y1 = Math.min(n-1, j+K);

                answer[i][j] = dp[x1+1][y1+1] - dp[x1+1][y0] - dp[x0][y1+1] + dp[x0][y0];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().matrixBlockSum(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }, 1)));
    }
}
