package p930;

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans = 0;
        int cur = 0;
        int sum = 0;

        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            if (sum == goal) {
                cur++;
            } else if (sum > goal){
                while (l <= r && sum > goal) {
                    sum -= nums[l];
                    ans += cur;
                    l++;
                }
                cur = 1;
            }
        }
        ans += cur;

        while (l < nums.length && sum == goal) {
            sum -= nums[l];
            if (sum == goal) {
                ans++;
            }
            l++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
    }
}
