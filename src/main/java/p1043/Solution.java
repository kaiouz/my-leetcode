package p1043;

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j > i - k && j >= 0; j--) {
                max = Math.max(max, arr[j]);
                dp[i+1] = Math.max(dp[i+1], dp[j] + max * (i - j + 1));
            }
        }

        return dp[arr.length];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3));
    }
}
