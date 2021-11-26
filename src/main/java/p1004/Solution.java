package p1004;

class Solution {

    public int longestOnes(int[] A, int K) {
        int max = 0;

        int zeroCount = 0;
        int l = -1;

        for (int r = 0; r < A.length; r++) {
            if (A[r] == 1) {
                max = Math.max(max, r - l);
            } else {
                zeroCount++;
                if (zeroCount <= K) {
                    max = Math.max(max, r - l);
                } else {
                    while (zeroCount > K && l < r) {
                        ++l;
                        if (A[l] == 0) {
                            zeroCount--;
                        }
                    }
                }
            }
        }

        return max;
    }

}
