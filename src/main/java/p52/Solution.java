package p52;

class Solution {
    int count = 0;
    int[] selected;
    int n;

    public int totalNQueens(int n) {
        this.n = n;
        selected = new int[n];
        dfs(0);
        return count;
    }

    private void dfs(int i) {
        if (i == n) {
            count++;
            return;
        }

        boolean[] map = new boolean[n];

        for (int k = 0; k < i; k++) {
            map[selected[k]] = true;
            int index = selected[k] - k + i;
            if (index >= 0 && index < n) {
                map[index] = true;
            }
            index = selected[k] + k - i;
            if (index >= 0 && index < n) {
                map[index] = true;
            }
        }

        for (int k = 0; k < n; k++) {
            if (!map[k]) {
                selected[i] = k;
                dfs(i+1);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().totalNQueens(4));
    }
}
