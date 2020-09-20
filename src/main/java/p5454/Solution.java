package p5454;

class Solution {

    public int numSubmat(int[][] mat) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                sum += unitMatNum(mat, i, j);
            }
        }
        return sum;
    }

    private int unitMatNum(int[][] mat, int i, int j) {
        int sum = 0;
        int iL = mat.length;
        int jL = mat[i].length;
        for (int ii = i; ii < iL; ii++) {
            if (mat[ii][j] != 1) {
                break;
            }
            for (int jj = j; jj < jL; jj++) {
                if (isUnit(mat, i, j, ii, jj)) {
                    sum++;
                } else {
                    jL = jj;
                    break;
                }
            }
        }
        return sum;
    }

    private boolean isUnit(int[][] mat, int i, int j, int ii, int jj) {
        for (int jjj = j; jjj <= jj; jjj++) {
            if (mat[ii][jjj] != 1) {
                return false;
            }
        }
        for (int iii = i; iii <= ii; iii++) {
            if (mat[iii][jj] != 1) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().numSubmat(
                new int[][]{{1,0,1},{1,1,0},{1,1,0}}
        ));
    }

}
