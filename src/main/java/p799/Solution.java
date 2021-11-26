package p799;

class Solution {

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] towers = new double[query_row + 1][];

        for (int i = 0; i < towers.length; i++) {
            towers[i] = new double[i + 1];
        }

        towers[0][0] += poured;

        for (int j = 0; j < towers.length - 1; j++) {

            for (int k = 0; k < towers[j].length; k++) {
                if (towers[j][k] > 1.0) {
                    double inc = (towers[j][k] - 1.0) / 2.0;
                    towers[j + 1][k] += inc;
                    towers[j + 1][k + 1] += inc;
                }
            }

        }

        return Math.min(towers[query_row][query_glass], 1.0);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().champagneTower(2, 1, 1));
    }
}
