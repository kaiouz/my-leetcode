package p1546;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int maxNonOverlapping(int[] nums, int target) {
        Map<Integer, Integer> sumPrefix = new HashMap<>();
        sumPrefix.put(0, -1);

        int last = -1;
        int count = 0;

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            Integer start = sumPrefix.get(sum - target);
            if (start != null) {
                if (start >= last) {
                    count++;
                    last = i;
                }
            }
            sumPrefix.put(sum, i);
        }

        return count;
    }

}
