package p1712;

class Solution {

    public int waysToSplit(int[] nums) {
        int[] sum = new int[nums.length];
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            sum[i] = s;
        }

        int avg = s / 3;

        int ans = 0;

        for (int i = 0; i < nums.length && sum[i] <= avg; i++) {
            int l = findLeft(sum, i + 1, nums.length, sum[i] + sum[i]);

            if (l == -1) {
                break;
            }

            int r = findRight(sum, l, nums.length-1, (s - sum[i]) / 2 + sum[i]);

            if (r != -1) {
                ans = (ans + (r - l) + 1) % 1000000007;
            }
        }

        return ans;
    }

    private int findRight(int[] sum, int l, int r, int target) {
        int ans = -1;
        while (l < r) {
            int mid = (l + r)/2;
            if (sum[mid] <= target) {
                l = mid + 1;
                ans = mid;
            } else {
                r = mid;
            }
        }
        return ans;
    }

    private int findLeft(int[] sum, int l, int r, int target) {
        int ans = -1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (sum[mid] >= target) {
                r = mid;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().waysToSplit(new int[]{1,2,2,2,5,0}));
    }
}
