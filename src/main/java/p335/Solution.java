package p335;

import java.util.TreeMap;

class Solution {

    public boolean isSelfCrossing(int[] distance) {
        int[][] dirs = new int[][]{
                {0, 1},
                {-1, 0},
                {0, -1},
                {1, 0}
        };

        TreeMap<Integer, int[]> horizontal = new TreeMap<>();
        TreeMap<Integer, int[]> vertical = new TreeMap<>();

        int di = 0;
        int x = 0, y = 0;

        for (int dis : distance) {
            int dx = x + dirs[di][0] * dis;
            int dy = y + dirs[di][1] * dis;

            if (di == 0) {
                if (intersect(y, false, dy, true, dx, horizontal, vertical)) {
                    return true;
                }
                vertical.put(dx, new int[]{y, dy});
            } else if (di == 1) {
                if (intersect(dx, true, x, false, dy, vertical, horizontal)) {
                    return true;
                }
                horizontal.put(dy, new int[]{dx, x});
            } else if (di == 2) {
                if (intersect(dy, true, y, false, dx, horizontal, vertical)) {
                    return true;
                }
                vertical.put(dx, new int[]{dy, y});
            } else {
                if (intersect(x, false, dx, true, dy, vertical, horizontal)) {
                    return true;
                }
                horizontal.put(dy, new int[]{x, dx});
            }

            x = dx;
            y = dy;
            di = (di + 1) % dirs.length;
        }

        return false;
    }


    private boolean intersect(int from, boolean fromInclude, int to, boolean toInclude, int p,
                              TreeMap<Integer, int[]> map, TreeMap<Integer, int[]> other) {
        for (int[] dis : map.subMap(from, fromInclude, to, toInclude).values()) {
            if (p >= dis[0] && p <= dis[1]) {
                return true;
            }
        }

        int[] dis = other.get(p);
        return dis != null && from <= dis[1] && dis[0] <= to;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().isSelfCrossing(new int[]{1, 2, 3, 4}));
    }
}
