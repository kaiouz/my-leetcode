package p128;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> startMap = new HashMap<>();
        Map<Integer, Integer> endMap = new HashMap<>();
        int max = 0;

        for (int n : nums) {
            Integer prevEnd = endMap.get(n-1);
            Integer nextStart = endMap.get(n+1);

            if (prevEnd == null && nextStart == null) {
                startMap.put(n, 1);
                endMap.put(n, 1);
            } else if (prevEnd != null && nextStart != null) {

            } else if (prevEnd != null) {

            } else {

            }
        }

        return max;
    }

}
