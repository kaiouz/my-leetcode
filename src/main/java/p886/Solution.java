package p886;

import java.util.*;

class Solution {

    public boolean possibleBipartition(int N, int[][] dislikes) {

        Map<Integer, Item> cache = new HashMap<>();

        for (int[] dislike : dislikes) {
            Item item  = cache.computeIfAbsent(dislike[0], k -> new Item());
            item.next.add(dislike[1]);
            item = cache.computeIfAbsent(dislike[1], k -> new Item());
            item.next.add(dislike[0]);
        }

        for (Integer key : cache.keySet()) {
            if (!dfs(cache, key, 0, true)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(Map<Integer, Item> cache, Integer key, int nextGroup, boolean first) {
        Item cur = cache.get(key);
        if (cur.status != -1) {
            return first || cur.status == nextGroup;
        }

        cur.status = nextGroup;

        nextGroup = (nextGroup + 1) % 2;

        for (Integer next : cur.next) {
            if (!dfs(cache, next, nextGroup, false)) {
                return false;
            }
        }

        return true;
    }

    static class Item {
        int status;
        List<Integer> next;
        public Item() {
            this.status = -1;
            this.next = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().possibleBipartition(4, new int[][] {
                {1, 2},
                {1, 3},
                {2, 4}
        }));
    }
}
