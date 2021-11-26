package p299;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<>();

        int x = 0, y = 0;

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                x++;
            } else {
                map.compute(secret.charAt(i), (k, v) -> v == null ? 1 : v + 1);
            }
        }

        for (int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);
            if (c != secret.charAt(i)) {
                int count = map.getOrDefault(c, 0);
                if (count > 0) {
                    y++;
                    map.put(c, count - 1);
                }
            }
        }

        return x + "A" + y + "B";
    }

}
