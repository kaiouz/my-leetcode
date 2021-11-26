package p403;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canCross(int[] stones) {
        if (stones.length <= 1) {
            return true;
        }

        if (stones[1] != 1) {
            return false;
        }

        int len = stones.length+1;
        Map<Integer, boolean[]> dp = new HashMap<>(len);
        for (int n : stones) {
            dp.put(n, new boolean[len]);
        }

        dp.get(1)[1] = true;
        for (int i = 1; i < stones.length; i++) {
            boolean[] step = dp.get(stones[i]);
            for (int j = 1; j < step.length; j++) {
                if (step[j]) {
                    for (int k = j - 1; k <= j+1; k++) {
                        if (k > 0) {
                            boolean[] s = dp.get(stones[i]+k);
                            if (s != null) {
                                s[k] = true;
                            }
                        }
                    }
                }
            }
        }

        boolean[] ans = dp.get(stones[stones.length-1]);
        for (boolean can : ans) {
            if (can) {
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().canCross(new int[]{0,1,3,5,6,8,12,17}));
    }
}
