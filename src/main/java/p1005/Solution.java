package p1005;

import java.util.Arrays;

class Solution {

    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);

        int i;
        for (i = 0; i < A.length && K > 0 && A[i] < 0; i++) {
            A[i] = -A[i];
            K--;
        }

        if (K % 2 == 1) {
            if (i == 0) {
                A[i] = -A[i];
            } else if (i == A.length) {
                A[i - 1] = -A[i - 1];
            } else {
                if (A[i - 1] <= A[i]) {
                    A[i - 1] = -A[i -1];
                } else {
                    A[i] = -A[i];
                }
            }
        }

        int sum = 0;
        for (i = 0; i < A.length; i++) {
            sum += A[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestSumAfterKNegations(new int[] {2,-3,-1,5,-4}, 2));
    }

}
