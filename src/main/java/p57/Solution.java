package p57;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> range = new LinkedList<>();
        boolean insert = false;

        for (int[] interval : intervals) {
            if (!insert) {
                if (newInterval[0] < interval[0]
                        || (newInterval[0] == interval[0] && newInterval[1] < interval[1])) {
                    insert = true;
                    insertOrMerge(range, newInterval);
                    insertOrMerge(range, interval);
                } else {
                    insert(range, interval);
                }
            } else {
                insertOrMerge(range, interval);
            }
        }

        if (!insert) {
            insertOrMerge(range, newInterval);
        }

        int[][] ans = new int[range.size()][2];
        Iterator<int[]> iterator = range.iterator();
        for (int i = 0; i < ans.length; i++) {
            ans[i] = iterator.next();
        }

        return ans;
    }

    private void insert(LinkedList<int[]> range, int[] interval) {
        range.offerLast(interval);
    }

    private void insertOrMerge(LinkedList<int[]> range, int[] interval) {
        int[] last = range.peekLast();
        if (last != null && interval[0] <= last[1]) {
            range.pollLast();
            range.offerLast(new int[]{last[0], Math.max(last[1], interval[1])});
        } else {
            range.offerLast(interval);
        }
    }


    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})));
    }
}
