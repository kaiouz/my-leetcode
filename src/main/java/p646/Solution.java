package p646;

import java.util.Arrays;

class Solution {

    public int findLongestChain(int[][] pairs) {
        int[] dp = new int[pairs.length];
        dp[0] = 1;

        Arrays.sort(pairs, ((o1, o2) -> {
            int ans = Integer.compare(o1[0], o2[0]);
            if (ans == 0) {
                return Integer.compare(o1[1], o2[1]);
            }
            return ans;
        }));

        for (int i = 1; i < pairs.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[pairs.length - 1];
    }


}
