package p5185;

class Solution {

    public boolean threeConsecutiveOdds(int[] arr) {
        int num = 0;

        for (int n : arr) {
            if (n % 2 == 1) {
                if (++num >= 3) {
                    return true;
                }
            } else {
                num = 0;
            }
        }

        return false;
    }

}
