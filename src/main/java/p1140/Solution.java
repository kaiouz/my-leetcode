package p1140;

class Solution {
    public int stoneGameII(int[] piles) {
        int[][] cache = new int[piles.length+1][piles.length];
        int[] sumPrefix = new int[piles.length + 1];

        for (int i = 0; i < piles.length; i++) {
            sumPrefix[i + 1] = sumPrefix[i] + piles[i];
        }

        return dfs(1, 0, cache, sumPrefix);
    }

    private int dfs(int m, int index, int[][] cache, int[] sumPrefix) {
        if (index >= cache[0].length) {
            return 0;
        }

        if (cache[m][index] == 0) {
            for (int i = 1; i <= 2 * m && index + i <= cache[0].length; i++) {
                int next = dfs(Math.max(m, i), index + i, cache, sumPrefix);
                int cur = -sumPrefix[index] + sumPrefix[sumPrefix.length - 1] - next;
                cache[m][index] = Math.max(cache[m][index], cur);
            }
        }

        return cache[m][index];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().stoneGameII(new int[]{1}));
    }
}
