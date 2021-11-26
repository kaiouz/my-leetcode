package p452;

import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    public int findMinArrowShots(int[][] points) {
        LinkedList<int[]> range = new LinkedList<>();

        Arrays.sort(points, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });


        for (int[] point : points) {
            if (range.isEmpty()) {
                range.offerLast(point);
            } else {
                int[] prev = range.peekLast();
                if (point[0] <= prev[1]) {
                    range.pollLast();
                    range.offer(new int[]{point[0], Math.min(prev[1], point[1])});
                } else {
                    range.offerLast(point);
                }
            }
        }

        return range.size();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMinArrowShots(new int[][]{{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}}));
    }
}
