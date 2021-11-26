package p1654;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> forbiddenSet = new HashSet<>();
        for (int n : forbidden) {
            forbiddenSet.add(n);
        }

        Map<Integer, Integer> cache = new HashMap<>();

        return dfs(x, x, a, b, true, forbiddenSet, cache);
    }

    private int dfs(int cur, int x, int a, int b, boolean canLeft, Set<Integer> forbiddenSet, Map<Integer, Integer> cache) {
        if (cache.containsKey(cur)) {
            return cache.get(cur);
        }

        int ans;

        if (forbiddenSet.contains(cur)) {
            ans = -1;
        } else {
            if (cur < 0) {
                ans = -1;
            } else if (cur == 0) {
                ans = 0;
            } else if (cur > x) {
                if (a >= b && a < cur) {
                    ans = -1;
                } else {
                    ans = dfs(cur - a, x, a, b, true, forbiddenSet, cache);
                    if (ans != -1) {
                        ans++;
                    }
                }
            } else {
                int left = dfs(cur - a, x, a, b, true, forbiddenSet, cache);
                int right = -1;
                if (canLeft) {
                    right = dfs(cur + b, x, a, b, false, forbiddenSet, cache);
                }
                if (left == -1 && right == -1) {
                    ans = -1;
                } else if (left == -1) {
                    ans = right;
                } else if (right == -1) {
                    ans = left;
                } else {
                    ans = Math.min(left, right);
                }
                if (ans != -1) {
                    ans++;
                }
            }
        }

        cache.put(cur, ans);

        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().minimumJumps(new int[]{1,6,2,14,5,17,4}, 16, 9, 7));
    }
}
