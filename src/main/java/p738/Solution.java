package p738;

class Solution {

    public int monotoneIncreasingDigits(int N) {
        int[] num = new int[10];
        int p = num.length;

        int n = N;
        while (n != 0) {
            num[--p] = n % 10;
            n /= 10;
        }

        int r = num.length;

        for (int i = num.length - 2; i >= p; i--) {
            if (num[i] > num[i+1]) {
                num[i]--;
                r = i+1;
            }
        }

        for (int i = r; i < num.length; i++) {
            num[i] = 9;
        }

        int ans = 0;

        for (int i = p; i < num.length; i++) {
            ans = ans * 10 + num[i];
        }

        return ans;
    }
}
