package p91;

class Solution {

    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;

        for (int i = 1; i <= len; i++) {
            int v = 0;
            for (int j = i - 1; j >= 0 && j >= i - 2; j--) {
                int cur = (s.charAt(j) - '0');
                v = pow10(i - j - 1) * cur + v;
                if (cur > 0 && v <= 26) {
                    dp[i] += dp[j];
                }
            }
        }

        return dp[len];
    }

    private int pow10(int times) {
        int ans = 1;
        for (int i = 0; i < times; i++) {
            ans *= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("27"));
    }
}
