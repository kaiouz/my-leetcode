package p1365;

class Solution {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = new int[nums.length];

        for (int i = 0; i < ans.length; i++) {
            for (int n : nums) {
                if (n < nums[i]) {
                    ans[i]++;
                }
            }
        }

        return ans;
    }


}
