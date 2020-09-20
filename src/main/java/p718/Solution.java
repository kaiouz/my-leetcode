package p718;

class Solution {

    public int findLength(int[] A, int[] B) {

        int max = 0;

        // A不动，滑动B
        for (int i = 0; i < B.length; i++) {
            int maxLen = maxLen(A, B, 0, i, Math.min(A.length, B.length - i));
            max = Math.max(max, maxLen);
        }

        // B不动，滑动A
        for (int i = 0; i < A.length; i++) {
            int maxLen = maxLen(A, B, i, 0, Math.min(A.length - i, B.length));
            max = Math.max(max, maxLen);
        }

        return max;
    }

    private int maxLen(int[] A, int[] B, int a, int b, int len) {
        int max = 0;
        int cur = 0;
        while (len-- > 0) {
            if (A[a++] == B[b++]) {
                cur++;
                max = Math.max(max, cur);
            } else {
                cur = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findLength(new int[]{1, 2, 3, 2, 1},
                new int[]{3, 2, 1, 4, 7}));
    }
}
