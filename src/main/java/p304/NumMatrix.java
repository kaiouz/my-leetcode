package p304;

class NumMatrix {
    private int[][] sum;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = m > 0 ? matrix[0].length : 0;

        sum = new int[m][n];

        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < sum[i].length; j++) {
                sum[i][j] = matrix[i][j] + sumVal(i, j - 1) + sumVal(i - 1, j) - sumVal(i - 1, j - 1);
            }
        }
    }

    private int sumVal(int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }

        return sum[i][j];
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumVal(row2, col2) - sumVal(row2, col1-1) - sumVal(row1-1, col2) + sumVal(row1-1, col1-1);
    }

    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        });
        System.out.println();
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
