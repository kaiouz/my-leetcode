package offer49;

class Solution {

    private int[] nums = new int[1690];

    public Solution() {
        nums[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < 1690; i++) {
            nums[i] = Math.min(Math.min(nums[i2]*2, nums[i3]*3), nums[i5]*5);
            if (nums[i] == nums[i2] * 2) {
                i2++;
            } else if (nums[i] == nums[i3] * 3) {
                i3++;
            } else if (nums[i] == nums[i5] * 5) {
                i5++;
            }
        }
    }


    public int nthUglyNumber(int n) {
        return nums[n-1];
    }


    public static void main(String[] args) {
        System.out.println(new Solution().nthUglyNumber(10));
    }
}
