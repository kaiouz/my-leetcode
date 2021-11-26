package p5563;

import java.util.Arrays;

class Solution {

    private static final long MOD = 1000000007;

    public int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);
        long ans = 0;

        int end = inventory[inventory.length - 1];
        int i = inventory.length - 1;
        while (orders > 0) {
            while (i >= 0 && inventory[i] == end) {
                i--;
            }
            int start = i >= 0 ? inventory[i] : 0;
            int len = (inventory.length - 1 - i);
            int count = Math.min(orders, (end - start) * len);

            start = end - count / len;

            if (start < end) {
                ans = (sum(start, end, len) + ans) % MOD;
                count = (end - start) * len;
            } else {
                ans = (ans + (end * (long)count) % MOD) % MOD;
            }

            end = start;
            orders -= count;
        }

        return (int) ans;
    }

    private long sum(long start, long end, int len) {
        long ans = ((start + 1 + end) * (end - start) / 2) % MOD;
        ans = (ans * len) % MOD;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{773160767},
                252264991));
    }
}
