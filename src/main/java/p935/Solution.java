package p935;

import java.util.Arrays;

class Solution {

    public static final long MOD = 1000000007;

    public int knightDialer(int n) {
        long[] dp = new long[10];
        long[] temp = new long[10];
        Arrays.fill(dp, 1);

        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                next(dp, temp);
            } else {
                next(temp, dp);
            }
        }

        long sum = 0;
        long[] sumArr = n % 2 == 1 ? dp : temp;
        for (long num : sumArr) {
            sum = (sum + num) % MOD;
        }
        return (int) sum;
    }


    private void next(long[] prev, long[] next) {
        next[0] = (prev[4] + prev[6]) % MOD;
        next[1] = (prev[6] + prev[8]) % MOD;
        next[2] = (prev[7] + prev[9]) % MOD;
        next[3] = (prev[4] + prev[8]) % MOD;
        next[4] = (prev[0] + prev[3] + prev[9]) % MOD;
        next[5] = 0;
        next[6] = (prev[0] + prev[1] + prev[7]) % MOD;
        next[7] = (prev[2] + prev[6]) % MOD;
        next[8] = (prev[1] + prev[3]) % MOD;
        next[9] = (prev[2] + prev[4]) % MOD;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().knightDialer(3131));
    }
}
