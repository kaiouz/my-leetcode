package offer40;

import java.util.PriorityQueue;

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int [] ans = new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<>(arr.length);
        for (int n : arr) {
            queue.add(n);
        }
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll();
        }

        return ans;
    }
}
