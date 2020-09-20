package p685;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {

    private List<Integer>[] conns;

    private int[] nodes;
    private int[] du;

    public int[] findRedundantDirectedConnection(int[][] edges) {
        conns = new List[edges.length + 1];
        nodes = new int[edges.length + 1];
        du = new int[edges.length + 1];

        for (int[] edge : edges) {
            if (conns[edge[0]] == null) {
                conns[edge[0]] = new ArrayList<>();
            }
            conns[edge[0]].add(edge[1]);
        }

        int[] d = new int[]{0, 0};

        for (int[] edge : edges) {
            if (du[edge[1]] > 0) {
                d = edge;
            }
            du[edge[1]]++;
        }

        for (int i = 1; i < conns.length; i++) {
            if (nodes[i] != -1) {
                if (dfs(i) >= 0) {
                    if (nodes[d[1]] > 0) {
                        for (int j = edges.length - 1; j >= 0; j--) {
                            if (nodes[edges[j][0]] > 0 && nodes[edges[j][0]] == edges[j][1] && edges[j][1] == d[1]) {
                                return edges[j];
                            }
                        }
                    } else {
                        for (int j = edges.length - 1; j >= 0; j--) {
                            if (nodes[edges[j][0]] > 0 && nodes[edges[j][0]] == edges[j][1]) {
                                return edges[j];
                            }
                        }
                    }
                }
            }
        }

        return d;
    }

    private int dfs(int cur) {
        if (nodes[cur] == -1) {
            return -1;
        }

        if (nodes[cur] > 0) {
            return nodes[cur];
        }

        List<Integer> next = conns[cur] != null ? conns[cur] : Collections.emptyList();
        for (Integer n : next) {
            nodes[cur] = n;
            int r = dfs(n);
            if (r > 0) {
                if (r == nodes[cur]) {
                    return 0;
                } else {
                    return r;
                }
            } else if (r == 0) {
                nodes[cur] = -1;
                return 0;
            }
        }

        nodes[cur] = -1;
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findRedundantDirectedConnection(new int[][]{
                {4, 2}, {1, 5}, {5, 2}, {5, 3}, {2, 4}
        })));
    }
}
