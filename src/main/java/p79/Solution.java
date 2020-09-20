package p79;

class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int idx) {
        if (idx >= word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }

        if (word.charAt(idx) != board[i][j]) {
            return false;
        }

        char cur = board[i][j];
        board[i][j] = '*';

        boolean find = dfs(board, i - 1, j, word, idx + 1)
                || dfs(board, i + 1, j, word, idx + 1)
                || dfs(board, i, j - 1, word, idx + 1)
                || dfs(board, i, j + 1, word, idx + 1);

        board[i][j] = cur;

        return find;
    }
}
