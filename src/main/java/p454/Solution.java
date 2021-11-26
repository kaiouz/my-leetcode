package p454;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                cache.compute(a+b, (k, v) -> v == null ? 1 : v + 1);
            }
        }

        int ans = 0;
        for (int c : C) {
            for (int d: D) {
                ans += cache.getOrDefault(-c-d, 0);
            }
        }

        return ans;
    }


}
