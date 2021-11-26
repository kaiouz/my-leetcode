package p1893;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, Comparator.comparingInt(it -> it[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        merged.add(new int[]{ranges[0][0], ranges[0][1]});
        for (int i = 1; i < ranges.length; i++) {
            int[] range = merged.peekLast();
            if (ranges[i][0] <= range[1]+1) {
                range[1] = Math.max(range[1], ranges[i][1]);
            } else {
                merged.addLast(new int[]{ranges[i][0], ranges[i][1]});
            }
        }
        for (int[] range : merged) {
            if (range[0] <= left && range[1] >= right) {
                return true;
            }
        }
        return false;
    }
}
