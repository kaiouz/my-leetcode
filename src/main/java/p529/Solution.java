package p529;

class Solution {

    public char[][] updateBoard(char[][] board, int[] click) {
        path(board, click[0], click[1]);
        return board;
    }

    private void path(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return;
        }
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else if (board[x][y] == 'E') {
            int num = nums(board, x, y);
            if (num > 0) {
                board[x][y] = (char) ('0' + num);
            } else {
                board[x][y] = 'B';
                path(board, x - 1, y);
                path(board, x + 1, y);
                path(board, x, y - 1);
                path(board, x, y + 1);

                path(board, x - 1, y - 1);
                path(board, x + 1, y + 1);
                path(board, x + 1, y - 1);
                path(board, x - 1, y + 1);
            }
        }
    }

    private int nums(char[][] board, int x, int y) {
        int m = board.length;
        int n = board[0].length;
        int sum = 0;

        if (x > 0 && y > 0 && board[x - 1][y - 1] == 'M') {
            sum++;
        }

        if (x > 0 && board[x - 1][y] == 'M') {
            sum++;
        }

        if (x > 0 && y < n - 1 && board[x - 1][y + 1] == 'M') {
            sum++;
        }

        if (y > 0 && board[x][y - 1] == 'M') {
            sum++;
        }

        if (y < n - 1 && board[x][y + 1] == 'M') {
            sum++;
        }

        if (x < m - 1 && y > 0 && board[x + 1][y - 1] == 'M') {
            sum++;
        }

        if (x < m - 1 && board[x + 1][y] == 'M') {
            sum++;
        }

        if (x < m - 1 && y < n - 1 && board[x + 1][y + 1] == 'M') {
            sum++;
        }

        return sum;
    }
}
