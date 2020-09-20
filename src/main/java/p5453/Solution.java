package p5453;

class Solution {

    public int getLastMoment(int n, int[] left, int[] right) {
        int max = 0;

        for (int i = 0; i < left.length; i++) {
            max = Math.max(max, left[i]);
        }

        for (int j = 0; j < right.length; j++) {
            max = Math.max(max, n - right[j]);
        }

        return max;
    }

}
