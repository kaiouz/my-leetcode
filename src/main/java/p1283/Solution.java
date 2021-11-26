package p1283;

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = Integer.MAX_VALUE;
        int pivot = left;

        int ans = left;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (isValid(nums, threshold, pivot)) {
                right = pivot - 1;
                ans = pivot;
            } else {
                left = pivot + 1;
            }
        }

        return ans;
    }

    private boolean isValid(int[] nums, int threshold, int val) {
        int sum = 0;
        for (int n : nums) {
            sum += (n - 1) / val + 1;
            if (sum > threshold) {
                return false;
            }
        }
        return sum <= threshold;
    }
}
