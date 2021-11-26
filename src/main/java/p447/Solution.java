package p447;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int numberOfBoomerangs(int[][] points) {

        int ans = 0;

        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    map.compute(compute(points[i], points[j]), (k, v) -> {
                       return v == null ? 1 : v + 1;
                    });
                }
            }

            for (Map.Entry<Integer, Integer> entries: map.entrySet()) {
                if (entries.getValue() >= 2) {
                    ans += entries.getValue() * (entries.getValue() - 1);
                }
            }
        }

        return ans;
    }


    private int compute(int[] x, int[] y) {
        int dx = x[0] - y[0];
        int dy = x[1] - y[1];
        return dx * dx + dy * dy;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().numberOfBoomerangs(new int[][]{
                {0, 0},
                {1, 0},
                {2, 0}
        }));
    }
}
