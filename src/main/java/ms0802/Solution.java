package ms0802;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution {

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        boolean[][] dp = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    dp[i][j] = obstacleGrid[i][j] == 0 && (dp[i - 1][j] || dp[i][j - 1]);
                } else if (i > 0) {
                    dp[i][j] = obstacleGrid[i][j] == 0 && dp[i - 1][j];
                } else if (j > 0) {
                    dp[i][j] = obstacleGrid[i][j] == 0 && dp[i][j-1];
                } else {
                    dp[i][j] = obstacleGrid[i][j] == 0;
                }
            }
        }

        if (!dp[m - 1][n - 1]) {
            return Collections.emptyList();
        } else {
            LinkedList<List<Integer>> ans = new LinkedList<>();
            ans.addFirst(Arrays.asList(m - 1, n - 1));

            int i = m - 1, j = n - 1;
            while (i != 0 || j != 0) {
                if (i > 0 && dp[i - 1][j]) {
                    i--;
                    ans.addFirst(Arrays.asList(i, j));
                    continue;
                }
                if (j > 0 && dp[i][j - 1]) {
                    j--;
                    ans.addFirst(Arrays.asList(i, j));
                    continue;
                }
            }

            return ans;
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().pathWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }

}
