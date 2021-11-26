package p797;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>>[] cache = new List[graph.length];
        return dfs(cache, graph, 0);
    }

    private List<List<Integer>> dfs(List<List<Integer>>[] cache, int[][] graph, int cur) {
        if (cache[cur] == null) {
            if (cur == graph.length - 1) {
                cache[cur] = Collections.singletonList(Collections.singletonList(cur));
            } else {
                cache[cur] = new LinkedList<>();
                for (int next : graph[cur]) {
                    List<List<Integer>> paths = dfs(cache, graph, next);
                    for (List<Integer> path : paths) {
                        cache[cur].add(newList(cur, path));
                    }
                }
            }
        }
        return cache[cur];
    }

    private List<Integer> newList(int cur, List<Integer> list) {
        List<Integer> ans = new ArrayList<>(list.size() + 1);
        ans.add(cur);
        ans.addAll(list);
        return ans;
    }
}
