package ms0807;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<String> ans;

    public String[] permutation(String S) {
        ans = new ArrayList<>();

        dfs(new char[S.length()], new boolean[S.length()], S, 0);

        return ans.toArray(new String[0]);
    }

    private void dfs(char[] temp, boolean[] selected, String S, int next) {
        if (next >= temp.length) {
            ans.add(new String(temp));
            return;
        }

        for (int i = 0; i < S.length(); i++) {
            if (!selected[i]) {
                selected[i] = true;
                temp[next] = S.charAt(i);
                dfs(temp, selected, S, next + 1);
                selected[i] = false;
            }
        }

    }

}
