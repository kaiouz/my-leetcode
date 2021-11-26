package p213;

class Solution {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(rob(nums, 1, nums.length - 2) + nums[nums.length - 1],
                rob(nums, 0, nums.length - 1));
    }

    private int rob(int[] nums, int start, int end) {
        int prevRob = 0;
        int prevNoRob = 0;

        for (int i = start; i < end; i++) {
            int rob = prevNoRob + nums[i];
            prevNoRob = Math.max(prevNoRob, prevRob);
            prevRob = rob;
        }

        return Math.max(prevRob, prevNoRob);
    }


    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[]{2, 3, 2}));
    }

}
