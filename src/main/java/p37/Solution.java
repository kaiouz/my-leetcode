package p37;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private boolean[][] line = new boolean[9][9];
    private boolean[][] col = new boolean[9][9];
    private boolean[][][] block = new boolean[3][3][9];

    private List<int[]> space = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    space.add(new int[]{i, j});
                } else {
                    int s = board[i][j] - '0' - 1;
                    line[i][s] = col[j][s] = block[i / 3][j / 3][s] = true;
                }
            }
        }

        dfs(board, 0);
    }

    private boolean dfs(char[][] board, int pos) {
        if (pos >= space.size()) {
            return true;
        }

        int[] s = space.get(pos);
        int i = s[0], j = s[1];

        for (int k = 0; k < 9; k++) {
            if (!line[i][k] && !col[j][k] && !block[i / 3][j / 3][k]) {
                line[i][k] = col[j][k] = block[i / 3][j / 3][k] = true;
                board[i][j] = (char) ('0' + k + 1);
                if (dfs(board, pos+1)) {
                    return true;
                }
                line[i][k] = col[j][k] = block[i / 3][j / 3][k] = false;
            }
        }

        return false;
    }


}
