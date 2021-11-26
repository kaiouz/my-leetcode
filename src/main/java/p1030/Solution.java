package p1030;

import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int count = R * C;
        int[][] ans = new int[count][];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ans[i * C + j] = new int[]{i, j};
            }
        }

        Arrays.sort(ans, Comparator.comparingInt(it -> Math.abs(it[0] - r0) + Math.abs(it[1] - c0)));

        return ans;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().allCellsDistOrder(2, 3, 1, 2)));
    }

}
