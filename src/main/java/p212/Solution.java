package p212;

import java.util.*;

class Solution {

    public List<String> findWords(char[][] board, String[] words) {
        Dictionary dict = new Dictionary();
        for (String word : words) {
            dict.add(word, 0);
        }

        Set<String> ans = new HashSet<>();

        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = true;
                dfs(visited, board, dict.words[board[i][j] - 'a'], ans, i, j);
                visited[i][j] = false;
            }
        }

        return new ArrayList<>(ans);
    }

    int[][] dirs = new int[][] {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };

    private void dfs(boolean[][] visited, char[][] board, Dictionary dict, Set<String> ans, int x, int y) {
        if (dict == null) {
            return;
        }

        if (dict.value != null) {
            ans.add(dict.value);
        }

        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[x].length
                && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(visited, board, dict.words[board[nx][ny] - 'a'], ans, nx, ny);
                visited[nx][ny] = false;
            }
        }
    }

    static class Dictionary {
        Dictionary[] words = new Dictionary[26];
        String value;

        public void add(String word, int index) {
            if (index >= word.length()) {
                value = word;
                return;
            }

            int i = word.charAt(index) - 'a';
            if (words[i] == null) {
                words[i] = new Dictionary();
            }
            words[i].add(word, index + 1);
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().findWords(new char[][]{
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        }, new String[]{"oath","pea","eat","rain"}));
    }
}
