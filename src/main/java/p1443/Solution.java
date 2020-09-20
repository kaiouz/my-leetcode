package p1443;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<Integer>[] edgeses = new List[n];
        for (int[] ed : edges) {
            if (edgeses[ed[0]] == null) {
                edgeses[ed[0]] = new ArrayList<Integer>(2);
            }
            edgeses[ed[0]].add(ed[1]);
            if (edgeses[ed[1]] == null) {
                edgeses[ed[1]] = new ArrayList<Integer>(2);
            }
            edgeses[ed[1]].add(ed[0]);
        }

        boolean[] select = new boolean[n];

        int sec = helper(edgeses, hasApple, select, 0);
        return Math.max(sec, 0);
    }

    private int helper(List<Integer>[] edges, List<Boolean> hasApple, boolean[] select, int cur) {
        select[cur] = true;

        if (edges[cur] == null || edges[cur].isEmpty()) {
            return hasApple.get(cur) ? 0 : -1;
        }

        int sec = 0;
        for (Integer n : edges[cur]) {
            if (!select[n]) {
                int sums = helper(edges, hasApple, select, n);
                if (sums >= 0) {
                    sec += sums + 2;
                }
            }
        }

        if (sec > 0) {
            return sec;
        } else {
            return hasApple.get(cur) ? 0 : -1;
        }
    }
}
