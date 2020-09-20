package p834;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private int[] res;
    private List<Integer>[] path;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        res = new int[N];
        path = new List[N];

        for (int i = 0; i < N; i++) {
            path[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            path[edge[0]].add(edge[1]);
            path[edge[1]].add(edge[0]);
        }

        dfs(0, -1);
        return res;
    }

    private List<Item> dfs(int cur, int parent) {
        List<List<Item>> children = new ArrayList<>();
        for (Integer i : path[cur]) {
            if (i != parent) {
                List<Item> child = dfs(i, cur);
                if (!child.isEmpty()) {
                    children.add(child);
                }
            }
        }

        for (int i = 0; i < children.size(); i++) {
            for (int j = i + 1; j < children.size(); j++) {
                for (Item item1 : children.get(i)) {
                    for (Item item2 : children.get(j)) {
                        res[item1.node] += item1.depth + item2.depth;
                        res[item2.node] += item1.depth + item2.depth;
                    }
                }
            }
        }

        List<Item> result = new ArrayList<>();
        result.add(new Item(cur, 1));
        for (List<Item> items : children) {
            for (Item item : items) {
                res[cur] += item.depth;
                res[item.node] += item.depth;
                item.depth++;
                result.add(item);
            }
        }
        return result;
    }

    class Item {
        public Item(int node, int depth) {
            this.node = node;
            this.depth = depth;
        }

        int node;
        int depth;
    }

}
