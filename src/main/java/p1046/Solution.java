package p1046;

import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(stones.length, (o1, o2) -> o2 - o1);
        for (int stone : stones) {
            queue.offer(stone);
        }

        int x, y;

        while (queue.size() > 1) {
            y = queue.poll();
            x = queue.poll();
            y = y - x;
            if (y > 0) {
                queue.offer(y);
            }
        }

        return queue.isEmpty() ? 0 : queue.poll();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lastStoneWeight(new int[] {2, 7, 4, 1, 8, 1}));
    }
}
