package p18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {

    private List<List<Integer>> ans;

    List<Integer> list;


    public List<List<Integer>> fourSum(int[] nums, int target) {
        ans = new LinkedList<>();
        list = new ArrayList<>(4);

        Arrays.sort(nums);

        dfs(target, nums, true, 0);

        return ans;
    }

    private void dfs(int cur, int[] nums, boolean prevSelect, int index) {
        if (list.size() == 4) {
            if (cur == 0) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        if (index >= nums.length || (cur > 0 && nums[index] > cur)) {
            return;
        }

        if (prevSelect || (nums[index] != nums[index - 1])) {
            list.add(nums[index]);
            dfs(cur - nums[index], nums, true, index + 1);
            list.remove(list.size() - 1);
        }

        dfs(cur, nums, false, index + 1);
    }


    public static void main(String[] args) {
        System.out.println(new Solution().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }

}
