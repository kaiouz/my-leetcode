package p576;

class Solution {

    public static final int MOD = 1000000007;

    public int findPaths(int m, int n, int N, int i, int j) {
        if (N == 0) {
            return 0;
        }

        long[][][] dp = new long[2][m][n];

        for (int k = 0; k < n; k++) {
            dp[0][0][k]++;
            dp[0][m - 1][k]++;
        }
        for (int k = 0; k < m; k++) {
            dp[0][k][0]++;
            dp[0][k][n - 1]++;
        }

        long ans = dp[0][i][j];

        for (int k = 2; k <= N; k++) {

            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    dp[1][x][y] = 0;
                    if (x > 0) {
                        dp[1][x][y] += dp[0][x - 1][y];
                    }
                    if (x < m - 1) {
                        dp[1][x][y] += dp[0][x + 1][y];
                    }
                    if (y > 0) {
                        dp[1][x][y] += dp[0][x][y - 1];
                    }
                    if (y < n - 1) {
                        dp[1][x][y] += dp[0][x][y + 1];
                    }
                    dp[1][x][y] %= MOD;
                }
            }

            swap(dp);
            ans = (ans + dp[0][i][j]) % MOD;
        }

        return (int) ans;
    }


    private void swap(long[][][] dp) {
        long[][] temp = dp[0];
        dp[0] = dp[1];
        dp[1] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findPaths(3, 8, 0, 2, 0));
    }
}
