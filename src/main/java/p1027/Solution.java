package p1027;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestArithSeqLength(int[] A) {
        int ans = 0;

        Map<Integer, Integer>[] dp = new Map[A.length];
        dp[0] = new HashMap<>();

        for (int i = 1; i < A.length; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j];
                int cur = dp[j].getOrDefault(diff, 1) + 1;
                dp[i].compute(diff, (k, v) -> v == null ? cur : Math.max(cur, v));
                ans = Math.max(ans, cur);
            }
        }

        return ans;
    }
}
