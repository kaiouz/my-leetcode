package p122;

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }

        int income = 0;

        for (int i = 0; i < prices.length; i++) {
            if ((i == 0 && prices[i] < prices[i + 1])
                    || (i > 0 && i + 1 < prices.length && prices[i] <= prices[i - 1] && prices[i] < prices[i + 1])) {
                income -= prices[i];
            } else if ((i > 0 && i < prices.length - 1 && prices[i] > prices[i - 1]) && prices[i] >= prices[i + 1]
            || (i == prices.length - 1 && prices[i] > prices[i - 1])) {
                income += prices[i];
            }
        }

        return income;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[] {1 , 1, 0}));
    }
}
