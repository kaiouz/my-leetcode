package p494;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> prev = Collections.singletonMap(0, 1);
        for (int n : nums) {
            Map<Integer, Integer> cur = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : prev.entrySet()) {
                int np = entry.getKey() + n;
                cur.put(np, entry.getValue() + cur.getOrDefault(np, 0));
                int nm = entry.getKey() - n;
                cur.put(nm, entry.getValue() + cur.getOrDefault(nm, 0));
            }
            prev = cur;
        }
        return prev.getOrDefault(target, 0);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findTargetSumWays(new int[]{1}, 2));
    }
}
