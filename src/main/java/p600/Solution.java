package p600;

class Solution {
    public int findIntegers(int n) {
        if (n == 0) {
            return 1;
        }

        int[] count = new int[33];
        count[0] = 1;
        count[1] = 2;
        count[2] = 3;
        for (int i = 3; i < count.length; i++) {
            count[i] = count[i-1] + count[i-2];
        }

        int ans = 0;

        int bit = bits(n);

        int pre = 0;
        int i = 0;
        for (i = bit; i >= 0; i--) {
            if (((1 << i) & n) != 0) {
                ans += count[i];
                if (pre == 1) {
                    break;
                }
                pre = 1;
            } else {
                pre = 0;
            }
        }
        if (i < 0) {
            ans++;
        }
        return ans;
    }

    private int bits(int n) {
        int ans = -1;
        while (n != 0) {
            ans++;
            n = n >>> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findIntegers(5));
    }
}
