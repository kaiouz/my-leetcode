package p5509;

class Solution {

    public int minCost(String s, int[] cost) {
        int l = 0, r = 1;

        int sum = 0;

        while (r <= s.length()) {
            if (r >= s.length()) {
                if (r - l > 1) {
                    sum += getCost(cost, l, r);
                }
                break;
            }
            if (s.charAt(l) != s.charAt(r)) {
                if (r - l > 1) {
                    sum += getCost(cost, l, r);
                }
                l = r;
            }
            r++;
        }

        return sum;
    }

    private int getCost(int[] cost, int l, int r) {
        int max = 0;
        int sum = 0;
        for (int i = l; i < r; i++) {
            sum += cost[i];
            max = Math.max(max, cost[i]);
        }
        return sum - max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minCost("aabaa", new int[]{1,2,3,4,1}));
    }
}
