package p528;

import java.util.Arrays;
import java.util.Random;

class Solution {

    private int[] sum;

    private Random random;

    private int bound = 0;

    public Solution(int[] w) {
        int s = 0;
        sum = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            s += w[i];
            sum[i] = s;
        }
        bound = s;

        random = new Random(System.currentTimeMillis());
    }

    public int pickIndex() {
        int s = random.nextInt(bound) + 1;
        int index = Arrays.binarySearch(sum, s);
        if (index >= 0) {
            return index;
        } else {
            return -index - 1;
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
