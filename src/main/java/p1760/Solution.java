package p1760;

class Solution {

    public int minimumSize(int[] nums, int maxOperations) {
        int r = Integer.MIN_VALUE;
        for (int n : nums) {
            r = Math.max(r, n);
        }

        int l = 1;
        int ans = r;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (canSplit(nums, mid, maxOperations)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    private boolean canSplit(int[] nums, int mid, int maxOperations) {
        int cost = 0;

        for (int n : nums) {
            cost += (n - 1) / mid;
            if (cost > maxOperations) {
                return false;
            }
        }

        return true;
    }
}
