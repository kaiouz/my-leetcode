package p1562;

import java.util.Arrays;

class Solution {


    public int findLatestStep(int[] arr, int m) {
        if (m == arr.length) {
            return arr.length;
        }

        int[][] endpoints = new int[arr.length][2];
        Arrays.fill(endpoints, new int[]{0, arr.length});

        for (int step = arr.length - 1; step >= 0; step--) {
            int index = arr[step] - 1;
            int[] endpoint = endpoints[index];
            int leftLen = index - endpoint[0];
            int rightLen = endpoint[1] - index - 1;

            if (leftLen == m || rightLen == m) {
                return step;
            }

            if (leftLen <= rightLen) {
                Arrays.fill(endpoints, endpoint[0], index, new int[]{endpoint[0], index});
                if (index < endpoint[1] - 1) {
                    endpoints[index + 1][0] = index + 1;
                }
            } else {
                Arrays.fill(endpoints, index + 1, endpoint[1], new int[]{index + 1, endpoint[1]});
                if (index > endpoint[0]) {
                    endpoints[index - 1][1] = index;
                }
            }
        }

        return -1;
    }
}
