package p255;

class Solution {

    public boolean isBipartite(int[][] graph) {
        int[] nodes = new int[graph.length];

        for (int i = 0; i < nodes.length; ++i) {
            if (nodes[i] == 0) {
                if (!dfs(graph, nodes, 1, i)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int[][] graph, int[] nodes, int c, int node) {
        nodes[node] = c;
        int cN = c == 1 ? 2 : 1;
        for (int i = 0; i < graph[node].length; ++i) {
            if (nodes[graph[node][i]] == 0) {
                if (!dfs(graph, nodes, cN, graph[node][i])) {
                    return false;
                }
            } else if (nodes[graph[node][i]] != cN) {
                return false;
            }
        }
        return true;
    }


}
