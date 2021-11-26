package p1130;

class Solution {

    public int mctFromLeafValues(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];

        for (int n = 0; n < arr.length; n++) {
            for (int i = 0, j = n; j < arr.length; i++, j++) {
                if (i == j) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(max(arr, i, k) * max(arr, k + 1, j) + dp[i][k] + dp[k + 1][j], dp[i][j]);
                    }
                }
            }
        }

        return dp[0][arr.length - 1];
    }

    private int max(int[] arr, int i, int j) {
        int m = Integer.MIN_VALUE;
        for (int n = i; n <= j; n++) {
            if (arr[n] > m) {
                m = arr[n];
            }
        }
        return m;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mctFromLeafValues(new int[]{2, 3, 5, 7}));
    }
}
