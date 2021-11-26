package p5564;

class Solution {

    public static final int MOD = 1000000007;

    public int createSortedArray(int[] instructions) {
        int ans = 0;

        for (int i = 0; i < instructions.length; i++) {
            int small = 0;
            int big = 0;
            for (int j = 0; j < i; j++) {
                if (instructions[j] < instructions[i]) {
                   small++;
                } else if (instructions[j] > instructions[i]) {
                    big++;
                }
            }
            ans = (ans + Math.min(small, big)) % MOD;
        }

        return ans;
    }
}
