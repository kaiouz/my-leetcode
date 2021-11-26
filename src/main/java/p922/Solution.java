package p922;

class Solution {

    public int[] sortArrayByParityII(int[] A) {
        if (A.length <= 1) {
            return A;
        }

        int[] ans = new int[A.length];

        int i = 0;
        int j = 1;

        for (int n : A) {
            if (n % 2 == 0) {
                ans[i] = n;
                i += 2;
            } else {
                ans[j] = n;
                j += 2;
            }
        }

        return ans;
    }

}
