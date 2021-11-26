package p373;

import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0 || nums2.length == 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> ans = new LinkedList<>();

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(it -> it[0] + nums2[it[1]]));

        for (int n : nums1) {
            queue.add(new int[]{n, 0});
        }

        int i = 0;

        while (i < k && !queue.isEmpty()) {
            int[] it = queue.poll();
            ans.add(Arrays.asList(it[0], nums2[it[1]]));
            if (++it[1] < nums2.length) {
                queue.add(it);
            }
            i++;
        }

        return ans;
    }
}
