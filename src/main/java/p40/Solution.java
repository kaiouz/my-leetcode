package p40;

import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> temp = new ArrayList<>();

        Map<Integer, Boolean> select = new HashMap<>();

        dfs(candidates, 0, target, select, temp, result);
        return result;
    }

    private void dfs(int[] candidates, int cur, int target, Map<Integer, Boolean> select, List<Integer> temp, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (cur >= candidates.length) {
            return;
        }

        Boolean before = select.get(candidates[cur]);
        if (before == null || before == Boolean.TRUE) {
            temp.add(candidates[cur]);
            dfs(candidates, cur + 1, target - candidates[cur], select, temp, result);
            temp.remove(temp.size() - 1);
        }

        select.put(candidates[cur], Boolean.FALSE);
        dfs(candidates, cur + 1, target, select, temp, result);
        select.put(candidates[cur], before);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }
}
