package p76;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public String minWindow(String s, String t) {
        Map<Character, Integer> chars = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            chars.compute(t.charAt(i), (k, v) -> v != null ? v + 1 : 1);
        }

        int remain = chars.size();

        int minLen = Integer.MAX_VALUE;
        int minIndex = -1;

        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            Integer count = chars.get(c);
            if (count != null) {
                count--;
                chars.put(c, count);
                if (count == 0) {
                    remain--;
                }
            }

            if (remain == 0) {
                while (l <= r && remain == 0) {
                    char lc = s.charAt(l);
                    Integer lCount = chars.get(lc);
                    if (lCount != null) {
                        lCount++;
                        chars.put(lc, lCount);
                        if (lCount == 1) {
                            remain++;
                        }
                    }
                    l++;
                }
                if (r - l + 2 < minLen) {
                    minIndex = l-1;
                    minLen = r - l + 2;
                }
            }
        }

        return minIndex == -1 ? "" : s.substring(minIndex, minIndex + minLen);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("a", "aa"));
    }
}
