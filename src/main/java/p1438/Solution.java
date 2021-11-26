package p1438;

import java.util.LinkedList;

class Solution {

    public int longestSubarray(int[] nums, int limit) {
        LinkedList<Integer> max = new LinkedList<>();
        LinkedList<Integer> min = new LinkedList<>();

        int ans = 0;

        int l = -1;
        for (int r = 0; r < nums.length; r++) {
            while (!max.isEmpty() && max.peekLast() < nums[r]) {
                max.pollLast();
            }
            max.addLast(nums[r]);

            while (!min.isEmpty() && min.peekLast() > nums[r]) {
                min.pollLast();
            }
            min.addLast(nums[r]);

            int distance = max.peekFirst() - min.peekFirst();
            if (distance <= limit) {
                ans = Math.max(ans, r - l);
            } else {
                while (distance > limit && l < r) {
                    l++;
                    if (max.peekFirst() == nums[l]) {
                        max.pollFirst();
                    }
                    if (min.peekFirst() == nums[l]) {
                        min.pollFirst();
                    }
                    distance = (max.isEmpty() ? 0 : max.peekFirst()) - (min.isEmpty() ? 0 : min.peekFirst());
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestSubarray(new int[]{10, 1, 2, 4, 7, 2},
                5));
    }

}
