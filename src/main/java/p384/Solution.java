package p384;

import java.util.Arrays;
import java.util.Random;

class Solution {

    private int[] nums;
    private int[] nums2;

    public Solution(int[] nums) {
        this.nums = nums;
        this.nums2 = Arrays.copyOf(nums, nums.length);
    }

    public int[] reset() {
        for (int i = 0; i < nums.length; i++) {
            nums2[i] = nums[i];
        }
        return nums2;
    }

    public int[] shuffle() {
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < nums.length; i++) {
            int j = i + random.nextInt(nums.length - i);
            int temp = nums2[j];
            nums2[j] = nums2[i];
            nums2[i] = temp;
        }

        return nums2;
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
