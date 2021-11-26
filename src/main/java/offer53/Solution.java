package offer53;

class Solution {
    public int missingNumber(int[] nums) {
        int l = 0;
        int r = nums.length;

        int mid = 0;
        while (l < r) {
            mid = (l + r) / 2;
            if (mid < nums[mid]) {
                r = mid;
            } else if (mid == nums[mid]) {
                l = mid + 1;
            }
        }

        if (l < nums.length && l != nums[l]) {
            return l;
        } else {
            return r;
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().missingNumber(new int[] {0, 2}));
    }

}
