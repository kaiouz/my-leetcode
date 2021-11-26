package ms1606;

import java.util.Arrays;

class Solution {
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        long prev = Integer.MIN_VALUE - 2L * Integer.MAX_VALUE;
        long cur = 0;
        long min = Integer.MAX_VALUE;

        int ai = 0, bi = 0;

        while (ai < a.length && bi < b.length) {
            if (a[ai] < b[bi]) {
                cur = a[ai++];
            } else if (a[ai] > b[bi]) {
                cur = b[bi++];
            } else {
                return 0;
            }
            min = Math.min(min, cur - prev);
            prev = cur;
        }

        while (ai < a.length) {
            min = Math.min(min, a[ai] - prev);
            prev = a[ai++];
        }

        while (bi < b.length) {
            min = Math.min(min, b[bi] - prev);
            prev = b[bi++];
        }

        return (int) min;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().smallestDifference(new int[] {0}, new int[] {2147483647}));
    }
}
