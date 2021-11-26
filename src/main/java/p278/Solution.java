package p278;
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution {
    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;

        int mid = l;
        int ans = -1;

        while (l <= r) {
            mid = l + (r - l) / 2;
            if (isBadVersion(mid)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    private boolean isBadVersion(int mid) {
        return mid >= 1702766719;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().firstBadVersion(2126753390));
    }
}
