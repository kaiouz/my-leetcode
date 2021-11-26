package p525;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max = 0;
        int ones = 0;

        for (int i = 0; i < nums.length; i++) {
            ones += nums[i];
            int diff = ones - (i+1) + ones;
            Integer exist = map.get(diff);

            if (exist != null) {
                max = Math.max(max, i - exist);
            } else {
                map.put(diff, i);
            }
        }

        return max;
    }

}
