package p174;

class Solution {

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int dp[] = new int[n];
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                int v = Integer.MAX_VALUE;
                if (i == m - 1 && j == n - 1) {
                    v = 1;
                }
                if (i < m - 1) {
                    v = dp[j];
                }
                if (j < n - 1) {
                    v = Math.min(v, dp[j + 1]);
                }
                dp[j] = Math.max(1, v - dungeon[i][j]);
            }
        }

        return dp[0];
    }


    public static void main(String[] args) {
        System.out.println(new Solution().calculateMinimumHP(
                new int[][]{
                        {-2, -3, 3},
                        {-5, -10, 1},
                        {10, 30, -5}
                }
        ));
    }

}
