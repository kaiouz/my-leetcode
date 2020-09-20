package p120;

import java.util.List;

class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int totalLevel = triangle.size();
        int[] dp = new int[totalLevel];

        for (int i = 0; i < totalLevel; ++i) {
            dp[i] = triangle.get(totalLevel - 1).get(i);
        }

        for (int level = totalLevel - 2; level >= 0; --level) {
            for (int i = 0; i <= level; ++i) {
                dp[i] = Math.min(dp[i], dp[i + 1]) + triangle.get(level).get(i);
            }
        }

        return dp[0];
    }
}
