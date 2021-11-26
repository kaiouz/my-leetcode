package p300;

class Solution {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (i < nums.length) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j]);
                    }
                } else {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i]++;
        }

        return dp[dp.length - 1] - 1;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLIS(new int[0]));
    }
}
