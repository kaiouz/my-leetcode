package p455;

import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int gi = 0, si = 0;

        while (gi < g.length && si < s.length) {
            if (s[si] >= g[gi]) {
                gi++;
            }
            si++;
        }

        return gi;
    }
}
