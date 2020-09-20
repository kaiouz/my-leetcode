package p39;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    private List<List<Integer>> ans = new LinkedList<>();
    private List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, 0, target, 0);
        return ans;
    }

    private void dfs(int[] candidates, int cur, int target, int start) {
        if (cur > target) {
            return;
        }
        if (cur == target) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            dfs(candidates, cur + candidates[i], target, i);
            temp.remove(temp.size() - 1);
        }
    }
}
