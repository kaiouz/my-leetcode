package p368;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        int[] max = new int[]{0, -1};
        int[][] dp = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 1;
            dp[i][1] = -1;

            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && dp[j][0] + 1 > dp[i][0]) {
                    dp[i][0] = dp[j][0] + 1;
                    dp[i][1] = j;
                }
            }

            if (dp[i][0] > max[0]) {
                max[0] = dp[i][0];
                max[1] = i;
            }
        }

        LinkedList<Integer> ans = new LinkedList<>();
        int[] cur = max;
        while (cur[1] != -1) {
            ans.addFirst(nums[cur[1]]);
            cur = dp[cur[1]];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestDivisibleSubset(new int[] {1,2,4,8}));
    }

}
