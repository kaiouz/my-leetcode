package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem3 {

    public int lengthOfLongestSubstring(String s) {
        int max = 0;

        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        int l = 0, r;

        for (r = 0; r < len; r++) {
            char c = s.charAt(r);
            Integer idx = map.get(c);
            if (idx != null && idx >= l) {
                if (r - l > max) {
                    max = r -l;
                }
                l = idx + 1;
            }
            map.put(c, r);
        }

        if (r - l > max) {
            max = r - l;
        }

        return max;
    }


    public static void main(String[] args) {
        new Problem3().lengthOfLongestSubstring("abba");
    }
}
