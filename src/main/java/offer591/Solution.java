package offer591;

import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!stack.isEmpty() && stack.peekLast() < nums[i]) {
                stack.pollLast();
            }
            stack.addLast(nums[i]);
        }

        int[] ans = new int[nums.length - k + 1];
        ans[0] = stack.peekFirst();

        for (int l = 0, r = k; r < nums.length; r++, l++) {
            if (stack.peekFirst() == nums[l]) {
                stack.pollFirst();
            }
            while (!stack.isEmpty() && stack.peekLast() < nums[r]) {
                stack.pollLast();
            }
            stack.addLast(nums[r]);
            ans[r - k + 1] = stack.peekFirst();
        }

        return ans;
    }
}
