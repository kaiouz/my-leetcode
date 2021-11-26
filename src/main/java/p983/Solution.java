package p983;

class Solution {

    public int mincostTickets(int[] days, int[] costs) {
        int[] durations = new int[]{1, 7, 30};
        int[] dp = new int[days.length + 1];

        for (int i = 0; i < days.length; i++) {
            dp[i + 1] = Integer.MAX_VALUE;

            for (int j = 0; j < durations.length; j++) {
                int prevDay = days[i] - durations[j];

                int k = i - 1;
                while (k >= 0) {
                    if (days[k] <= prevDay) {
                        break;
                    }
                    k--;
                }

                dp[i + 1] = Math.min(dp[i + 1], dp[k + 1] + costs[j]);
            }

        }

        return dp[days.length];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));
    }
}
