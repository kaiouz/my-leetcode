package p1770;

class Solution {

    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;
        int[][] dp = new int[n + 2][n + 2];

        for (int i = m; i >= 1; i--) {
            for (int j = n - m + i; j <= n; j++) {
                int next = Math.max(n  - j + i - 1, 0);
                dp[i][j] = Math.max(
                        nums[i - 1] * multipliers[next] + dp[i + 1][j],
                        nums[j - 1] * multipliers[next] + dp[i][j - 1]
                );
            }
        }

        return dp[1][n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumScore(
                new int[]{1,2,3},
                new int[]{3,2,1})
        );
    }
}
