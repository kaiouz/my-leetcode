package p503;

import java.util.Arrays;
import java.util.LinkedList;

class Solution {

    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];

        if (ans.length == 0) {
            return ans;
        }

        LinkedList<Integer> stack = new LinkedList<>();

        int maxIndex = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        ans[maxIndex] = -1;
        stack.push(max);

        for (int i = maxIndex - 1 + nums.length; i > maxIndex; i--) {
            Integer item = null;
            int idx = i % nums.length;
            while ((item = stack.peekLast()) != null && nums[idx] >= item) {
                stack.pollLast();
            }
            ans[idx] = item == null ? -1 : item;
            stack.offerLast(nums[idx]);
        }

        return ans;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().nextGreaterElements(new int[]{1, 2, 1})));
    }


}
