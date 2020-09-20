package p51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    char[] template;

    public List<List<String>> solveNQueens(int n) {
        template = new char[n];
        Arrays.fill(template, '.');

        int[] board = new int[n];
        boolean[] select = new boolean[n];
        List<List<String>> result = new ArrayList<>();
        dfs(board, select, 0, result);
        return result;
    }

    private void dfs(int[] board, boolean[] select, int row, List<List<String>> result) {
        if (row >= board.length) {
            result.add(genResult(board));
            return;
        }

        for (int i = 0; i < select.length; i++) {
            if (!select[i] && isValid(board, row, i, row)) {
                select[i] = true;
                board[row] = i;
                dfs(board, select, row + 1, result);
                select[i] = false;
            }
        }
    }

    private boolean isValid(int[] board, int row, int x, int y) {
        for (int i = 0; i < row; i++) {
            if (board[i] - i == x - y || board[i] + i == x + y) {
                return false;
            }
        }
        return true;
    }

    private List<String> genResult(int[] board) {
        ArrayList<String> list = new ArrayList<>(board.length);

        for (int i = 0; i < board.length; i++) {
            template[board[i]] = 'Q';
            list.add(new String(template));
            template[board[i]] = '.';
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solveNQueens(4));
    }

}
