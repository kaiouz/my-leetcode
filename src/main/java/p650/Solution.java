package p650;

class Solution {

    public int minSteps(int n) {
        int ans = 0;

        int cur = 1;
        int next = 1;
        int p = 1;

        while (cur < n) {
            while (cur < next) {
                cur += p;
                ans++;
            }

            if (cur == next) {
                p = cur;
                ans++;
            }

            do {
                next++;
            } while (next < n && n % next != 0);
        }

        return ans - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minSteps(3));
    }
}
