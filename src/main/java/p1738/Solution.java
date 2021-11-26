package p1738;

import java.util.PriorityQueue;

class Solution {

    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        PriorityQueue<Integer> queue = new PriorityQueue<>(k+1);

        int[][] sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i][j-1] ^ sum[i-1][j] ^ sum[i-1][j-1] ^ matrix[i-1][j-1];

                queue.add(sum[i][j]);
                if (queue.size() > k) {
                    queue.remove();
                }
            }
        }

        return queue.peek();
    }

}
