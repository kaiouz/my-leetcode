package p56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(it -> it[0]));

        List<int[]> ans = new ArrayList<>(intervals.length);
        int[] cur = new int[] {intervals[0][0], intervals[0][1]};

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= cur[1]) {
                cur[1] = Math.max(cur[1], intervals[i][1]);
            } else {
                ans.add(cur);
                cur = new int[]{intervals[i][0], intervals[i][1]};
            }
        }

        ans.add(cur);

        return ans.toArray(new int[0][2]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }
}
