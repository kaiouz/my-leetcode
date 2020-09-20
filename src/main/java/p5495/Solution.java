package p5495;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] ns = new int[n + 1];

        for (int i = 1; i < rounds.length; i++) {
            int start = i > 1 ? rounds[i - 1] + 1 : rounds[i-1];
            if (rounds[i] < start) {
                for (int j = start; j <= n; j++) {
                    ns[j]++;
                }
                for (int j = 1; j <= rounds[i]; j++) {
                    ns[j]++;
                }
            } else {
                for (int j = start; j <= rounds[i]; j++) {
                    ns[j]++;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        List<Integer> index = null;

        for (int i = 1; i < ns.length; i++) {
            if (ns[i] > max) {
                max = ns[i];
                index = new ArrayList<>();
                index.add(i);
            } else if (ns[i] == max) {
                index.add(i);
            }
        }

        return index;
    }

    public static void main(String[] args) {
        new Solution().mostVisited(4, new int[]{1, 3, 1, 2});
    }
}
