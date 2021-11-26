package p813;

class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        double[][] dp = new double[A.length + 1][K + 1];

        int[] sum = new int[A.length + 1];
        int s = 0;
        for (int i = 0; i < A.length; i++) {
            s += A[i];
            sum[i+1] = s;
        }

        for (int i = 1; i <= A.length; i++) {
            int count = Math.min(i, K);

            dp[i][1] = sum[i] / (double)i;
            for (int j = 2; j <= count; j++) {
                for (int start = j - 1; start < i; start++) {
                    dp[i][j] = Math.max(dp[i][j], dp[start][j-1] + (sum[i] - sum[start]) / (double)(i - start));
                }
            }
        }

        return dp[A.length][K];
    }


    public static void main(String[] args) {
        System.out.println(new Solution().largestSumOfAverages(new int[]{9,1,2,3,9}, 3));
    }
}
