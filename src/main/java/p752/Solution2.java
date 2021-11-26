package p752;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution2 {

    public int openLock(String[] deadends, String target) {
        Set<Integer> visited = new HashSet<>();

        for (String deadend : deadends) {
            visited.add(Integer.parseInt(deadend));
        }

        int tar = Integer.parseInt(target);
        if (visited.contains(tar)) {
            return -1;
        }

        if (tar == 0) {
            return 0;
        }

        int step = 1;
        visited.add(0);

        int[] dir = new int[]{1, -1};
        Set<Integer> cur = Collections.singleton(0);

        while (!cur.isEmpty()) {
            Set<Integer> next = new HashSet<>();

            for (int val : cur) {
                int[] s = split(val);

                for (int i = 0; i < s.length; i++) {
                    for (int d : dir) {
                        int t = combine(s, i, d);

                        if (t == tar) {
                            return step;
                        }

                        if (visited.add(t)) {
                            next.add(t);
                        }
                    }
                }

            }

            step++;
            cur = next;
        }

        return -1;
    }

    private int[] split(int val) {
        int[] ans = new int[4];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = val % 10;
            val /= 10;
        }
        return ans;
    }

    private int combine(int[] val, int j, int dir) {
        int ans = 0;
        for (int i = val.length - 1; i >= 0; i--) {
            if (j == i) {
                ans = ans * 10 + ((val[j] + 10 + dir) % 10);
            } else {
                ans = ans * 10 + val[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().openLock(new String[]{"0201", "0101", "0102", "1212", "2002"},
                "0202"));
    }
}
