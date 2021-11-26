package p688;

class Solution {

    public static final int[][] STEP = new int[][]{
            {2, 1},
            {1, 2},

            {-1, 2},
            {-2, 1},

            {-2, -1},
            {-1, -2},

            {1, -2},
            {2, -1}
    };

    public double knightProbability(int N, int K, int r, int c) {
        double[][][] dp = new double[K+1][N][N];
        dp[0][r][c] = 1;

        for (int k = 1; k <= K; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    for (int[] s : STEP) {
                        if (i + s[0] >= 0 && i + s[0] < N
                                && j + s[1] >= 0 && j + s[1] < N) {
                            dp[k][i][j] += dp[k - 1][i + s[0]][j + s[1]] / 8.0;
                        }
                    }

                }
            }
        }

        double[][] mat = dp[K];
        double ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans += mat[i][j];
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().knightProbability(8, 30, 6, 4));
    }
}
