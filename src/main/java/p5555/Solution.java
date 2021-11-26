package p5555;

class Solution {

    public int countVowelStrings(int n) {

        int ans = 0;
        for (int a = 0; a <= n; a++) {
            for (int e = 0; e <= n - a; e++) {
                for (int i = 0; i <= n - a - e; i++) {
                    for (int o = 0; o <= n - a - e - i; o++) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().countVowelStrings(50));
    }
}
