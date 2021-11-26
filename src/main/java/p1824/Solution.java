package p1824;

class Solution {
    public int minSideJumps(int[] obstacles) {
        int MAX = Integer.MAX_VALUE / 2;

        int[] dp = new int[]{MAX, 1, 0, 1};

        for (int i = 1; i < obstacles.length; i++) {
            int[] cur = new int[]{MAX, MAX, MAX, MAX};

            for (int j = 1; j <= 3; j++) {
                for (int k = 1; k <= 3; k++) {
                    if (k != obstacles[i]) {
                        if (j == k) {
                            cur[k] = Math.min(cur[k], dp[j]);
                        } else if (obstacles[i-1] == k && obstacles[i] == j) {
                            cur[k] = Math.min(cur[k], dp[j] + 2);
                        } else {
                            cur[k] = Math.min(cur[k], dp[j] + 1);
                        }
                    }
                }
            }

            dp = cur;
        }

        return Math.min(dp[1], Math.min(dp[2], dp[3]));
    }


    public static void main(String[] args) {
        System.out.println(new Solution().minSideJumps(new int[] {0, 1, 2, 3, 0}));
    }
}
