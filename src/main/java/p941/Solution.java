package p941;

class Solution {

    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }

        int peak = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                peak = i;
            } else {
                break;
            }
        }

        if (peak == 1 || peak >= A.length - 1) {
            return false;
        }

        for (int i = peak+1; i < A.length; i++) {
            if (A[i] >= A[i - 1]) {
                return false;
            }
        }

        return true;
    }
}
