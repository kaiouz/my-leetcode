package p1351;

class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int left = 0, right = m;
        int pivot = left;
        int neg = right;

        while (left < right) {
            pivot = (left + right) / 2;
            if (grid[pivot][0] < 0) {
                neg = pivot;
                right = pivot;
            } else {
                left = pivot + 1;
            }
        }

        int sum = (m - neg) * n;

        int stop = neg;
        for (int i = 0; i < stop; i++) {
            left = 0;
            right = n;
            neg = right;
            while (left < right) {
                pivot = (left + right) / 2;
                if (grid[i][pivot] < 0) {
                    neg = pivot;
                    right = pivot;
                } else {
                    left = pivot + 1;
                }
            }
            sum += n - neg;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countNegatives(
                new int[][]{
                        {5, 1, 0},
                        {-5, -5, -5}
                }
        ));
    }
}
