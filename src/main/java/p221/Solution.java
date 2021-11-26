package p221;

class Solution {

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int size = 0;

        for (int i = 0; i < m; i++) {
            if (m - i <= size) {
                break;
            }
            for (int j = 0; j < n; j++) {
                if (n - j <= size) {
                    break;
                }
                int curMaxSize = Math.min(m - i, n - j);
                for (int s = curMaxSize; s > size; s--) {
                    if (isValid(matrix, i, j, s)) {
                        size = s;
                        break;
                    }
                }
            }
        }

        return size * size;
    }

    private boolean isValid(char[][] matrix, int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (matrix[i][j] == '0') {
                    return false;
                }
            }
        }
        return true;
    }
}
