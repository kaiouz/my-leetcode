package p5490;

class Solution {

    public int minDays(int n) {
//        byte[] ns = new byte[n + 1];
//        ns[0] = 0;
//
//        for (int i = 1; i <= n; i++) {
//            ns[i] = ns[i - 1];
//            if (i % 2 == 0) {
//                ns[i] = (byte) Math.min(ns[i], ns[i/2]);
//            }
//            if (i % 3 == 0) {
//                ns[i] = (byte) Math.min(ns[i], ns[i/3]);
//            }
//            ns[i]++;
//        }
//
//        return ns[n];

        if (n == 0) {
            return 0;
        }

        if (n % 3 == 0) {
            return minDays(n / 3) + 1;
        }
        if (n % 2 == 0) {
            return minDays(n / 2) + 1;
        }
        return minDays(n -1) + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minDays(10));
    }

}
