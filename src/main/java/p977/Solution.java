package p977;

import java.util.Arrays;

class Solution {
    public int[] sortedSquares(int[] nums) {
        int l = 0, r = nums.length;

        int p = nums.length;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (mid - 1 < 0) {
                if (nums[mid] >= 0) {
                    p = 0;
                    break;
                } else {
                    l = mid + 1;
                }
            } else if (mid >= nums.length) {
                if (nums[mid - 1] < 0) {
                    p = nums.length;
                    break;
                } else {
                    r = mid - 1;
                }
            } else {
                if (nums[mid - 1] < 0 && nums[mid] < 0) {
                    l = mid + 1;
                } else if (nums[mid - 1] >= 0 && nums[mid] >= 0) {
                    r = mid - 1;
                } else {
                    p = mid;
                    break;
                }
            }
        }

        l = p-1;
        r = p;
        int i = 0;
        int[] ans = new int[nums.length];

        while (l >= 0 && r < nums.length) {
            int ll = nums[l] * nums[l];
            int rr = nums[r] * nums[r];
            if (ll <= rr) {
                ans[i++] = ll;
                l--;
            } else {
                ans[i++] = rr;
                r++;
            }
        }

        while (l >= 0) {
            ans[i++] = nums[l] * nums[l];
            l--;
        }

        while (r < nums.length) {
            ans[i++] = nums[r] * nums[r];
            r++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sortedSquares(new int[]{-1, 0, 1, 1})));
    }
}
