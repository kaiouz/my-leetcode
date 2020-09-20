package p216;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    private List<List<Integer>> ans;
    private List<Integer> temp;

    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new LinkedList<>();
        temp = new ArrayList<>(k);

        dfs(n, k, 1);
        return ans;
    }


    private void dfs(int target, int k, int cur) {
        if (k == 0) {
            if (target == 0) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        if (target <= 0) {
            return;
        }

        if (cur > 9) {
            return;
        }

        temp.add(cur);
        dfs(target - cur, k - 1, cur + 1);
        temp.remove(temp.size() - 1);

        dfs(target, k, cur + 1);
    }

}
