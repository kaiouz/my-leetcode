package ms1718;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int[] shortestSeq(int[] big, int[] small) {
        Map<Integer, int[]> counts = new HashMap<>();
        for (int n : small) {
            counts.put(n, new int[]{1});
        }
        int notMeets = small.length;


        int[] ans = new int[0];
        int min = Integer.MAX_VALUE;

        int l = 0;
        for (int r = 0; r < big.length; r++) {
            int[] count = counts.get(big[r]);
            if (count != null && --count[0] == 0 && --notMeets == 0) {
                while (notMeets == 0) {
                    int[] countl = counts.get(big[l]);
                    if (countl != null && countl[0]++ == 0) {
                        notMeets++;
                    }
                    l++;
                }
                if (r - l + 2 < min) {
                    min = r - l + 2;
                    ans = new int[]{l-1, r};
                }
            }
        }

        return ans;
    }


}
