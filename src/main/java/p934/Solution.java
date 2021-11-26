package p934;

import java.util.HashSet;
import java.util.Set;

class Solution {

    private int[][] A;

    private boolean[][]visited;

    public int shortestBridge(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        this.A = A;
        this.visited = new boolean[m][n];

        Set<Integer>[] sets = new Set[2];
        int idx = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1 && !visited[i][j] && idx < 2) {
                    sets[idx] = new HashSet<>();
                    dfs(sets[idx], i, j);
                    idx++;
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for (Integer p1 : sets[0]) {
            for (Integer p2 : sets[1]) {
                min = Math.min(min, Math.abs(p1/n - p2/n) + Math.abs(p1%n - p2%n) - 1);
            }
        }

        return min;
    }

    private void dfs(Set<Integer> set, int x, int y) {
        if (x < 0 || x >= A.length || y < 0 || y >= A[0].length) {
            return;
        }

        if (visited[x][y]) {
            return;
        }

        visited[x][y] = true;

        if (A[x][y] == 1 && set.add(x * A[0].length + y)) {
            dfs(set, x - 1, y);
            dfs(set, x + 1, y);
            dfs(set, x, y - 1);
            dfs(set, x, y + 1);
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().shortestBridge(new int[][]{
                {1,1,1,1,1},
                {1,0,0,0,1},
                {1,0,1,0,1},
                {1,0,0,0,1},
                {1,1,1,1,1}
        }));
    }
}
