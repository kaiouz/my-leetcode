package p1482;

import java.util.Arrays;

class Solution {

    public int minDays(int[] bloomDay, int m, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            min = Math.min(min, day);
            max = Math.max(max, day);
        }

        int left = min, right = max;
        int pivot = left;
        int ans = -1;

        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (isValid(bloomDay, m, k, pivot)) {
                right = pivot - 1;
                ans = pivot;
            } else {
                left = pivot + 1;
            }
        }

        return ans;
    }

    private boolean isValid(int[] bloomDay, int m, int k, int days) {
        int mCount = 0;
        int kCount = 0;

        for (int d : bloomDay) {
            if (d <= days) {
                if (++kCount == k) {
                    kCount = 0;
                    if (++mCount == m) {
                        return true;
                    }
                }
            } else {
                kCount = 0;
            }
        }
        return false;
    }

}
