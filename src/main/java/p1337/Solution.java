package p1337;

import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public int[] kWeakestRows(int[][] mat, int k) {
        int[][] power = new int[mat.length][2];
        for (int i = 0; i < mat.length; i++) {
            power[i][0] = i;
            power[i][1] = count(mat[i]);
        }
        return Arrays.stream(power)
                .sorted(Comparator.comparingInt(p -> p[1]))
                .limit(k)
                .mapToInt(p -> p[0])
                .toArray();
    }

    private int count(int[] arr) {
        int left = 0;
        int right = arr.length;
        int pivot = right;
        while (left < right) {
            pivot = (left + right) / 2;
            if (arr[pivot] == 0) {
                right = pivot;
            } else {
                left = pivot + 1;
            }
        }

        return right;
    }

}
