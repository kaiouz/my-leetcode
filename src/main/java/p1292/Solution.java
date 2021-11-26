package p1292;

class Solution {

    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] sum = new int[m][n];
        for (int i = 0; i < m; i++) {
            int s = 0;
            for (int j = 0; j < n; j++) {
                s += mat[i][j];
                sum[i][j] = s;
            }
        }

        int left = 1, right = Math.min(m, n);
        int pivot = 0;

        int ans = 0;
        while (left <= right) {
            pivot = (left + right) / 2;
            if (isValid(sum, pivot, threshold)) {
                left = pivot + 1;
                ans = pivot;
            } else {
                right = pivot - 1;
            }
        }

        return ans;
    }

    private boolean isValid(int[][] sum, int len, int threshold) {
        int m = sum.length - len;
        int n = sum[0].length - len;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int s = 0;

                for (int k = i; k < i + len; k++) {
                    s += sum[k][j + len - 1];
                    if (j > 0) {
                        s -= sum[k][j - 1];
                    }
                }

                if (s <= threshold) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSideLength(new int[][]{
                {1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}
        }, 4));
    }
}
