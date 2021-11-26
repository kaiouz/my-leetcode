package lcp07;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public int numWays(int n, int[][] relation, int k) {
        List<List<Integer>> path = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            path.add(new ArrayList<>());
        }
        for (int[] re : relation) {
            path.get(re[0]).add(re[1]);
        }

        dfs(path, n - 1, k, 0);

        return count;
    }

    private int count;

    private void dfs(List<List<Integer>> path, int target, int k, int n) {
        if (k == 0) {
            if (n == target) {
                count++;
            }
            return;
        }

        for (int next : path.get(n)) {
            dfs(path, target, k - 1, next);
        }
    }

}
