package p5561;

class Solution {

    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int[] ans = new int[n + 1];
        ans[0] = 0;
        ans[1] = 1;
        int max = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                ans[i] = ans[i / 2];
            } else {
                ans[i] = ans[i / 2] + ans[i / 2 + 1];
            }
            max = Math.max(max, ans[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getMaximumGenerated(7));
    }

}
