package p1588;

class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int ans = 0;
        for (int n = 1; n <= arr.length; n += 2) {
            int k = Math.min(n, arr.length - n+1);
            for (int i = 0; i < k - 1; i++) {
                ans += (i + 1) * arr[i];
            }
            for (int i = k - 1; i <= arr.length - k; i++) {
                ans += k * arr[i];
            }
            for (int i = arr.length - k + 1; i < arr.length; i++) {
                ans += (arr.length - i) * arr[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().sumOddLengthSubarrays(new int[]{1,4,2,5,3}));
    }
}
