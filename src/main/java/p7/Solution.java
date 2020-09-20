package p7;

class Solution {
    public int reverse(int x) {
        int[] nums = new int[10];
        int i = 0;
        int ne = 1;
        if (x < 0) {
            ne = -1;
            x = -x;
        }
        while (x > 0) {
            nums[i++] = x % 10;
            x /= 10;
        }
        int r = 0;
        for (int n=0; n < i; n++) {
            if (r > (Integer.MAX_VALUE - nums[n]) / 10) {
                return 0;
            } else {
                r = r * 10 + nums[n];
            }
        }
        return r * ne;
    }
}
