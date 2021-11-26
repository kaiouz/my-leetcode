package p1208;

class Solution {

    public int equalSubstring(String s, String t, int maxCost) {
        int[] costs = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            costs[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int l = -1;
        int sum = 0;
        int max = 0;
        for (int r = 0; r < costs.length; r++) {
            sum += costs[r];
            if (sum <= maxCost) {
                max = Math.max(max, r - l);
            } else {
                while (sum > maxCost && l < r) {
                    sum -= costs[++l];
                }
            }
        }

        return max;
    }

}
