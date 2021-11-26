package p218;

import java.util.*;

class Solution {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        LinkedList<List<Integer>> ans = new LinkedList<>();

        int i = 0;
        PriorityQueue<int[]> rightEdge = new PriorityQueue<>(Comparator.comparingInt(v -> v[0]));
        PriorityQueue<Integer> cur = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        int height = 0;

        while (i < buildings.length || !rightEdge.isEmpty()) {
            boolean insert = false;

            if (i < buildings.length) {
                insert = rightEdge.isEmpty() || buildings[i][0] <= rightEdge.peek()[0]  ;
            }

            if (insert) {
                cur.add(buildings[i][2]);
                rightEdge.add(new int[]{buildings[i][1], buildings[i][2]});
                int max = cur.peek();
                if (max != height) {
                    if (!ans.isEmpty() && ans.peekLast().get(0) == buildings[i][0]) {
                        ans.removeLast();
                    }
                    ans.add(point(buildings[i][0], max));
                    height = max;
                }
                i++;
            } else {
                int[] edge = rightEdge.remove();
                cur.remove(edge[1]);
                int max = cur.isEmpty() ? 0 : cur.peek();
                if (max != height) {
                    if (!ans.isEmpty() && ans.peekLast().get(0) == edge[0]) {
                        ans.removeLast();
                    }
                    ans.add(point(edge[0], max));
                    height = max;
                }
            }
        }

        return ans;
    }

    private List<Integer> point(int x, int height) {
        List<Integer> ans = new ArrayList<>(2);
        ans.add(x);
        ans.add(height);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getSkyline(new int[][] {{1, 2, 1},{1,2,2},{1,2,3}}));
    }
}
