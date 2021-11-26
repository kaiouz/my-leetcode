package p752;

import java.util.LinkedList;

class Solution {

    boolean[] visited = new boolean[10000];

    int[] op = new int[] {1, -1};

    public int openLock(String[] deadends, String target) {
        for (String dead : deadends) {
            visited[Integer.parseInt(dead)] = true;
        }

        int targetNum = Integer.parseInt(target);
        visited[targetNum] = true;

        if (targetNum == 0) {
            return 0;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        queue.offerLast(0);
        int step = 1;

        int size = 0;
        while ((size = queue.size()) != 0) {
            for (int i = 0; i < size; i++) {
                int n = queue.pollFirst();

                for (int k = 0; k < 4; k++) {
                    for (int p : op) {
                        int next = roll(n, k, p);

                        if (next == targetNum) {
                            return step;
                        }

                        if (!visited[next]) {
                            queue.offerLast(next);
                            visited[next] = true;
                        }
                    }
                }

            }

            step++;
        }

        return -1;
    }

    private int roll(int num, int p, int dir) {
        int ans = 0;
        int weight = 1;
        for (int i = 0; i < 4; i++) {
            if (p == i) {
                ans += weight * ((num + 10 + dir) % 10);
            } else {
                ans += weight * (num % 10);
            }
            weight *= 10;
            num /= 10;
        }
        return ans;
    }
}
