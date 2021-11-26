package p697;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> freq = new HashMap<>();

        List<int[]> maxFreq = null;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            int[] f = freq.get(nums[i]);
            if (f == null) {
                f = new int[]{1, i, i};
                freq.put(nums[i], f);
            } else {
                f[0]++;
                f[2] = i;
            }
            if (f[0] > max) {
                maxFreq = new ArrayList<>();
                maxFreq.add(f);
                max = f[0];
            } else if (f[0] == max) {
                maxFreq.add(f);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int[] f : maxFreq) {
           ans = Math.min(ans, f[2] - f[1]);
        }

        return ans + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
    }
}
