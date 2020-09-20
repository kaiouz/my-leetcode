package p5511;

class Solution {

    public int numSpecial(int[][] mat) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1 && isValid(mat, i, j)) {
                   sum++;
                }
            }
        }
        return sum;
    }

    private boolean isValid(int[][]mat, int i, int j) {
        for (int k = 0; k < mat[i].length; k++) {
            if (mat[i][k] == 1 && j != k) {
                return false;
            }
        }

        for (int k = 0; k < mat.length; k++) {
            if (mat[k][j] == 1 && i != k) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSpecial(
                new int[][]{
                        {1,0,0},
                        {0,0,1},
                        {1,0,0}
                }
        ));
    }

}
