package p130;

class Solution {

    private boolean[][] fill;
    private char[][] board;

    private int m;
    private int n;

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;

        this.board = board;
        fill = new boolean[m][n];

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(0, j);
            }
            if (board[m - 1][j] == 'O') {
                dfs(m - 1, j);
            }
        }

        for (int i = 1; i < m - 1; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0);
            }
            if (board[i][n - 1] == 'O') {
                dfs(i, n - 1);
            }
        }

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O' && !fill[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }

        if (board[i][j] == 'X') {
            return;
        }

        if (fill[i][j]) {
            return;
        }

        fill[i][j] = true;
        dfs(i - 1, j);
        dfs(i + 1, j);
        dfs(i, j - 1);
        dfs(i, j + 1);
    }

}
