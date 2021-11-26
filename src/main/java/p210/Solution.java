package p210;

import java.util.LinkedList;
import java.util.List;

class Solution {

    int next = 0;

    int[] ans;

    int[] visited;

    List[] paths;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ans = new int[numCourses];
        visited = new int[numCourses];

        paths = new List[numCourses];

        next = 0;

        for (int[] req : prerequisites) {
            if (paths[req[0]] == null) {
                paths[req[0]] = new LinkedList();
            }
            paths[req[0]].add(req[1]);
        }

        for (int i = 0; i < visited.length; i++) {
            if (!dfs(i)) {
                return new int[0];
            }
        }

        return ans;
    }

    private boolean dfs(int n) {
        if (visited[n] == 1) {
            return false;
        }
        if (visited[n] == 2) {
            return true;
        }

        visited[n] = 1;

        List<Integer> nexts = paths[n];

        if (nexts != null) {
            for (int nn : nexts) {
                if (!dfs(nn)) {
                    return false;
                }
            }
        }

        visited[n] = 2;

        ans[next++] = n;

        return true;
    }
}
