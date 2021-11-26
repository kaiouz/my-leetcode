package p377;

class Solution {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int n : nums) {
                if (n <= i) {
                    dp[i] += dp[i - n];
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum4(new int[]{1, 2, 3}, 35));
    }
}
