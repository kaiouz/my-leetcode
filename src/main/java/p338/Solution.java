package p338;

class Solution {

    public int[] countBits(int num) {
        int[] ans = new int[num+1];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = Integer.bitCount(i);
        }

        return ans;
    }


}
