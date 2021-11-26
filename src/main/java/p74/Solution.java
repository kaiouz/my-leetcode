package p74;

class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;

        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;

        int l = 0;
        int r = m * n;
        int mid = 0;

        while (l < r) {
            mid = (l + r) / 2;
            int val = value(matrix, mid, n);

            if (val < target) {
                l = mid + 1;
            } else if (val > target) {
                r = mid;
            } else {
                return true;
            }
        }

        return false;
    }

    private int value(int[][] matrix, int index, int n) {
        return matrix[index / n][index % n];
    }

}
