package p1191;

class Solution {

    public static final int MOD = 1000000007;


    public int kConcatenationMaxSum(int[] arr, int k) {
        long suffix = 0;
        long max = 0;
        long sum = 0;
        long prefix = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            prefix = Math.max(sum, prefix);
            suffix = Math.max(suffix + arr[i], arr[i]);
            max = Math.max(max, suffix);
        }

        if (k == 1) {
            return (int) (max % MOD);
        }

        long two = prefix + suffix;
        long three = sum * (k - 2) + prefix + suffix;

        return (int) (Math.max(Math.max(max, two), three) % MOD);
    }


    public static void main(String[] args) {
        System.out.println(new Solution().kConcatenationMaxSum(new int[]{1, 2}, 3));
    }
}
