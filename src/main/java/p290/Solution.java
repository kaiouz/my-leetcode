package p290;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> cache = new HashMap<>();
        HashSet<String> words = new HashSet<>();
        String[] ss = s.split(" ");

        if (ss.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < ss.length; i++) {
            Character c  = pattern.charAt(i);
            String expect = cache.get(c);
            if (expect == null) {
                if (!words.add(ss[i])) {
                    return false;
                }
                cache.put(c, ss[i]);
            } else {
                if (!expect.equals(ss[i])) {
                    return false;
                }
            }
        }

        return true;
    }
}
