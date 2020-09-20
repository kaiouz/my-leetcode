package p378;

class Solution {

    public int kthSmallest(int[][] matrix, int k) {
        int mk = 0;

        int[] index = new int[matrix.length];
        int line = 0;

        while (k-- > 0) {
            int min = Integer.MAX_VALUE;
            int minIdx = -1;

            for (int i = line; i < index.length; i++) {
                if (i > line && index[i] >= index[i - 1]) {
                    continue;
                }

                int cur = matrix[i][index[i]];
                if (matrix[i][index[i]] < min) {
                    min = cur;
                    minIdx = i;
                }
            }

            mk = min;
            if (++index[minIdx] >= index.length) {
                line++;
            }
        }

        return mk;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().kthSmallest(
                new int[][]{
                        {1, 4, 7, 11, 15},
                        {2, 5, 8, 12, 19},
                        {3, 6, 9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}
                },
                20
        ));
    }

}
