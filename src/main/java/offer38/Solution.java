package offer38;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {

    public String[] permutation(String s) {
        char[] ss = s.toCharArray();
        Arrays.sort(ss);

        boolean[] selected = new boolean[s.length()];
        char[] ret = new char[s.length()];
        List<String> ans = new LinkedList<>();

        dfs(ss, selected, ret, 0, ans);

        return ans.toArray(new String[0]);
    }

    private void dfs(char[] s, boolean[] selected, char[] ret, int next, List<String> ans) {
        if (next == ret.length) {
            ans.add(new String(ret));
            return;
        }

        char prev = ' ';
        for (int i = 0; i < s.length; i++) {
            if (prev != s[i] && !selected[i]) {
                prev = s[i];
                selected[i] = true;
                ret[next] = s[i];
                dfs(s, selected, ret, next+1, ans);
                selected[i] = false;
            }
        }
    }

}
