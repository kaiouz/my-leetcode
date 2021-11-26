package p375;

class Solution {


    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][2];

        for (int i = 2; i <= n; i++) {
            dp[i] = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};

            for (int j = 1; j <= i; j++) {
                int[] left = dp[j - 1];
                int[] right = new int[]{dp[i - j][0] + dp[i - j][1] * j, dp[i - j][1]};
                int[] max = new int[2];

                if (compare(left, right) >= 0) {
                    max[0] = left[0] + j;
                    max[1] = left[1] + 1;
                } else {
                    max[0] = right[0] + j;
                    max[1] = right[1] + 1;
                }

                if (compare(max, dp[i]) < 0) {
                    dp[i] = max;
                }
            }
        }

        return dp[n][0];
    }


    private int compare(int[] left, int[] right) {
        int first = Integer.compare(left[0], right[0]);
        if (first == 0) {
            return Integer.compare(left[1], right[1]);
        }
        return first;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().getMoneyAmount(10));
    }
}
