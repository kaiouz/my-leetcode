package p474;

class Solution {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (String str : strs) {
            int[] count = helper(str);
            for (int i = m; i >= 0; i--) {
                for (int j = n; j >= 0; j--) {
                    if (count[0] <= i && count[1] <= j) {
                        dp[i][j] = Math.max(dp[i][j], dp[i-count[0]][j-count[1]] + 1);
                    }
                }
            }
        }
        return dp[m][n];
    }

    private int[] helper(String str) {
        int[] ans = new int[2];

        for (int i = 0; i < str.length(); i++) {
            ans[str.charAt(i) - '0']++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMaxForm(
                new String[] {"10","0001","111001","1","0"},
        5,
        3
        ));
    }
}
