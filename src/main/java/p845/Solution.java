package p845;

class Solution {
    public static final int INIT = 0;
    public static final int UP = 1;
    public static final int DOWN = 0x10;

    public int longestMountain(int[] A) {

        int max = 0;
        int left = -1;
        int state = INIT;
        for (int right = 0; right < A.length; right++) {
            if ((state & UP) != 0 && (state & DOWN) != 0) {
                if (A[right] < A[right - 1]) {
                    state = DOWN;
                    max = Math.max(max, right - left);
                } else if (A[right] == A[right - 1]) {
                    state = UP;
                    left = right - 1;
                }
            } else if ((state & UP) != 0) {
                if (A[right] <= A[right - 1]) {
                    state = UP;
                    left = right - 1;
                } else {
                    state = UP | DOWN;
                }
            } else if ((state & DOWN) != 0) {
                if (A[right] == A[right - 1]) {
                    max = Math.max(max, right - left - 1);
                    state = UP;
                    left = right - 1;
                } else if (A[right] > A[right - 1]) {
                    max = Math.max(max, right - left - 1);
                    left = right - 2;
                    state = UP | DOWN;
                } else if (right == A.length - 1) {
                    max = Math.max(max, right - left);
                }
            } else {
                state = UP;
            }
        }

        return max;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().longestMountain(new int[]{8,3,7,3,4,10,1,1,2,8}));
    }

}
