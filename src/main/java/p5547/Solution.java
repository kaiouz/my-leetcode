package p5547;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            ans.add(isArithmetic(Arrays.copyOfRange(nums, l[i], r[i] + 1)));
        }

        return ans;
    }

    private boolean isArithmetic(int[] nums) {
        Arrays.sort(nums);
        if (nums.length <= 2) {
            return true;
        }
        int diff = nums[1] - nums[0];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != diff) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkArithmeticSubarrays(new int[]{-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10},
                new int[]{0,1,6,4,8,7},
                new int[]{4,4,9,7,9,10}));
    }
}
