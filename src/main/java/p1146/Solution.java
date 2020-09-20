package p1146;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<Dest>[] edages;
    private int sum;


    public int minReorder(int n, int[][] connections) {
        edages = new List[n];
        for (int[] con : connections) {
            if (edages[con[0]] == null) {
                edages[con[0]] = new ArrayList<>();
            }
            edages[con[0]].add(new Dest(con[1], false));
            if (edages[con[1]] == null) {
                edages[con[1]] = new ArrayList<>();
            }
            edages[con[1]].add(new Dest(con[0], true));
        }
        helper(0, -1);
        return sum;
    }

    private void helper(int cur, int parent) {
        List<Dest> dests = edages[cur];

        for (Dest dest : dests) {
            if (dest.node != parent) {
                if (dest.reverse) {
                    sum++;
                    helper(dest.node, cur);
                }
            }
        }
    }

    static class Dest {
        int node;
        boolean reverse;

        public Dest(int node, boolean reverse) {
            this.node = node;
            this.reverse = reverse;
        }
    }
}
