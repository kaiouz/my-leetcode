package p1594;

class Solution {

    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long[][][] dp = new long[m][n][2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = Long.MIN_VALUE;
                dp[i][j][1] = Long.MAX_VALUE;
            }
        }

        dp[0][0][0] = grid[0][0];
        dp[0][0][1] = grid[0][0];

        for (int i = 1; i < n; i++) {
            set(dp, grid, 0, i - 1, 0, i);
        }

        for (int i = 1; i < m; i++) {
            set(dp, grid, i - 1, 0, i, 0);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                set(dp, grid, i, j - 1, i, j);
                set(dp, grid, i - 1, j, i, j);
            }
        }

        if (dp[m - 1][n - 1][0] >= 0) {
            return (int) (dp[m - 1][n - 1][0] % 1000000007);
        } else {
            return -1;
        }
    }

    private void set(long[][][] dp, int[][] grid, int i, int j, int x, int y) {
        if (grid[x][y] >= 0) {
            dp[x][y][0] = Math.max(dp[x][y][0], grid[x][y] * dp[i][j][0]);
            dp[x][y][1] = Math.min(dp[x][y][1], grid[x][y] * dp[i][j][1]);
        } else {
            dp[x][y][0] = Math.max(dp[x][y][0], grid[x][y] * dp[i][j][1]);
            dp[x][y][1] = Math.min(dp[x][y][1], grid[x][y] * dp[i][j][0]);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProductPath(new int[][]{{-1, -2, -3}, {-2, -3, -3}, {-3, -3, -2}}));
    }
}
