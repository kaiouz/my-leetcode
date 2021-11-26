package p1262;

class Solution {

    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];

        int[] temp = new int[3];

        for (int n : nums) {
            for (int i = 0; i < 3; i++) {
                int c = n % 3;
                int t = (i + 3 - c) % 3;
                if (dp[t] != 0) {
                    temp[i] = Math.max(dp[i], dp[t] + n);
                } else {
                    temp[i] = dp[i];
                }
                temp[c] = Math.max(temp[c], n);
            }
            for (int i = 0; i < 3; i++) {
                dp[i] = temp[i];
            }
        }

        return dp[0];
    }


    public static void main(String[] args) {
        System.out.println(new Solution().maxSumDivThree(new int[]{3, 6, 5, 1, 8}));
    }
}
