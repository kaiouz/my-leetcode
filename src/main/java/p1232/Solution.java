package p1232;

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        final int y = coordinates[1][1] - coordinates[0][1];
        final int x = coordinates[1][0] - coordinates[0][0];

        for (int i = 2; i < coordinates.length; i++) {
            if (y * (coordinates[i][0] - coordinates[1][0]) != x * (coordinates[i][1] - coordinates[1][1])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkStraightLine(
                new int[][] {
                        {1, 2},
                        {2, 3},
                        {3, 4},
                        {4, 5},
                        {5, 6},
                        {6, 7}
                }
        ));
    }
}
