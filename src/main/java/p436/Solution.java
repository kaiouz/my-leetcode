package p436;

import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public int[] findRightInterval(int[][] intervals) {
        int[][] intervalVal = new int[intervals.length][2];
        for (int i = 0; i < intervalVal.length; i++) {
            intervalVal[i][0] = intervals[i][0];
            intervalVal[i][1] = i;
        }

        Arrays.sort(intervalVal, Comparator.comparingInt(arr -> arr[0]));
        int[] ans = new int[intervals.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = findIntervals(intervalVal, intervals[i][1]);
        }
        return ans;
    }

    private int findIntervals(int[][] intervalVal, int value) {
        int left = 0, right = intervalVal.length;
        int pivot = -1;
        while (left < right) {
            pivot = (left + right) / 2;
            if (intervalVal[pivot][0] >= value) {
                right = pivot;
            } else {
                left = pivot + 1;
            }
        }
        if (right < intervalVal.length) {
            return intervalVal[right][1];
        } else {
            return -1;
        }
    }
}
