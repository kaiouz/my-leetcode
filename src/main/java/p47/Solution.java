package p47;

import java.util.*;

class Solution {

    private List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int n : nums) {
            cache.compute(n, (k, v) -> v == null ? 1 : v + 1);
        }
        helper(cache, new LinkedList<>(), nums.length);
        return ans;
    }

    private void helper(Map<Integer, Integer> nums, LinkedList<Integer> temp, int size) {
        if (temp.size() >= size) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (Map.Entry<Integer, Integer> entry : nums.entrySet()) {
            if (entry.getValue() > 0) {
                entry.setValue(entry.getValue() - 1);
                temp.addLast(entry.getKey());
                helper(nums, temp, size);
                temp.removeLast();
                entry.setValue(entry.getValue() + 1);
            }
        }
    }

}
