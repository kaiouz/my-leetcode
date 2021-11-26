package p149;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    public int maxPoints(int[][] points) {
        if (points.length == 1) {
            return 1;
        }
        Map<Long, Set<Long>> map = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Set<Long> set = map.computeIfAbsent(lineHash(points[i], points[j]), k -> new HashSet<>());
                set.add(hash(points[i][0], points[i][1]));
                set.add(hash(points[j][0], points[j][1]));
            }
        }

        int ans = 0;
        for (Set<Long> set : map.values()) {
            ans = Math.max(ans, set.size());
        }

        return ans;
    }

    private long lineHash(int[] p1, int[] p2) {
        if (p1[0] == p2[0]) {
            return hash(100_00000, p1[0]) ;
        }

        int k = (p1[1] - p2[1]) / (p1[0] - p2[0]);
        int b = (p1[0] * p2[1] - p2[0] * p1[1]) / ((p1[0] - p2[0]));
        return hash(k, b);
    }

    private long hash(int a, int b) {
        long h = 0;
        if (a < 0) {
            h += 10_00000_00000L;
            a = -a;
        }
        if (b < 0) {
            h += 1_00000_00000L;
            b = -b;
        }
        h += a * 100000L;
        h += b;
        return h;
    }
}
