package p401;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        LinkedList<String> ans = new LinkedList<>();

        for (int i = 0; i < 2014; i++) {
            if (turnedOn == Integer.bitCount(i)) {
                int hour = i & 0b1111;
                if (hour >= 12) {
                    continue;
                }
                int min = i >>> 4;
                if (min >= 60) {
                    continue;
                }
                ans.add(hour + ":" + (min < 10 ? "0" + min: min));
            }
        }

        return ans;
    }
}
