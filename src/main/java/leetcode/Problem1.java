package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length / 2);

        for (int i = 0; i < nums.length; i++) {
            int expect = target - nums[i];
            Integer idx = map.get(expect);
            if (idx != null) {
                return new int[]{idx, i};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
