package offer48;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> count = new HashMap<>();
        int l = -1;
        int ans = 0;

        for (int r = 0; r < s.length(); r++) {
            if (count.compute(s.charAt(r), (k, v) -> v == null ? 1 : v + 1) < 2) {
                ans = Math.max(ans, r - l);
            } else {
                while (count.get(s.charAt(r)) > 1 && l < r) {
                    count.computeIfPresent(s.charAt(++l), (k, v) -> v - 1);
                }
            }
        }

        return ans;
    }
}
