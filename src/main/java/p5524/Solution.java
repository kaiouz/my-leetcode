package p5524;

class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int max = -1;
        int maxP = -1;

        int cur = 0;

        int num = 0;
        int i = 0;
        int p = 0;

        while (num > 0 || i < customers.length) {
            p++;
            if (i < customers.length) {
                num += customers[i];
                i++;
            }

            int n = Math.min(num, 4);
            num -= n;

            cur += n * boardingCost - runningCost;
            if (cur > max) {
                max = cur;
                maxP = p;
            }
        }

        return maxP;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minOperationsMaxProfit(new int[]{10,10,6,4,7}, 3,8));
    }
}
