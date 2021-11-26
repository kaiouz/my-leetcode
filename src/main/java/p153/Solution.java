package p153;

class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;

        int ans = nums[r];

        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] < ans) {
                r = mid - 1;
                ans = nums[mid];
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMin(new int[]{3,4, 5, 1,2}));
    }
}
