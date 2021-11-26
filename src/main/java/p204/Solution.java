package p204;

class Solution {

    public int countPrimes(int n) {
        int ans = 0;

        for (int i = 2; i < n; i++) {
            if (isPrimes(i)) {
                ans++;
            }
        }

        return ans;
    }

    private boolean isPrimes(int n) {
        int half = (int) Math.sqrt(n);
        for (int i = 2; i <= half; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().countPrimes(1));
    }
}
