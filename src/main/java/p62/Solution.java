package p62;

class Solution {


    public int uniquePaths(int m, int n) {
        int[] dp = new int[m];

        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                dp[j] = (i > 0 ? dp[j] : 0) + (j > 0 ? dp[j - 1] : 0);
            }
        }

        return dp[m - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(3, 7));
    }

}
