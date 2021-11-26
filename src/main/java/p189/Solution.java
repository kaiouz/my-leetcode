package p189;

import java.util.Arrays;

class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k > 0) {
            int times = 0;
            int round = 0;

            while (times < nums.length) {
                int first = nums[round];
                int i = round;
                int last = i + k;

                while (i != last) {
                    int next = (i - k + nums.length) % nums.length;
                    nums[i] = nums[next];
                    i = next;
                    times++;
                }

                nums[last] = first;
                times++;
                round++;
            }

        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        new Solution().rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }
}
