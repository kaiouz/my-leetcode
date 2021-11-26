package p764;

class Solution {

    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] grid = new int[N][N];
        for (int[] point : mines) {
            grid[point[0]][point[1]] = 1;
        }

        int[][][] count = new int[N][N][4];

        for (int i = 0; i < N; i++) {
            int zeroCount = 0;
            for (int j = 0; j < N; j++) {
                count[i][j][0] = zeroCount;
                if (grid[i][j] == 0) {
                    zeroCount++;
                } else {
                    zeroCount = 0;
                }
            }
            zeroCount = 0;
            for (int j = N-1; j >= 0; j--) {
                count[i][j][1] = zeroCount;
                if (grid[i][j] == 0) {
                    zeroCount++;
                } else {
                    zeroCount = 0;
                }
            }
        }

        for (int j = 0; j < N; j++) {
            int zeroCount = 0;
            for (int i = 0; i < N; i++) {
                count[i][j][2] = zeroCount;
                if (grid[i][j] == 0) {
                    zeroCount++;
                } else {
                    zeroCount = 0;
                }
            }
            zeroCount = 0;
            for (int i = N-1; i >= 0; i--) {
                count[i][j][3] = zeroCount;
                if (grid[i][j] == 0) {
                    zeroCount++;
                } else {
                    zeroCount = 0;
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0) {
                    int c = Math.min(Math.min(count[i][j][0], count[i][j][1]),
                            Math.min(count[i][j][2], count[i][j][3])) + 1;
                    ans = Math.max(ans, c);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().orderOfLargestPlusSign(5, new int[][]{{4, 2}}));
    }
}
