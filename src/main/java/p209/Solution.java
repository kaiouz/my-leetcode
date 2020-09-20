package p209;

class Solution {

    public int minSubArrayLen(int s, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int sum = 0;

        int left = 0, right = 0;

        while ((right < nums.length || sum >= s) && left <= right) {
            if (sum >= s) {
                minLen = Math.min(minLen, right - left);
            }

            if (sum >= s) {
                sum -= nums[left];
                left++;
            } else {
                sum += nums[right];
                right++;
            }

        }

        return minLen > nums.length ? 0 : minLen;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}
