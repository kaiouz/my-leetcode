package p1403;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

    public List<Integer> minSubsequence(int[] nums) {
        int sum = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(nums.length, (o1, o2) -> o2 - o1);
        for (int n : nums) {
            sum += n;
            queue.offer(n);
        }
        List<Integer> ans = new ArrayList<>();
        int ansSum = 0;
        while (!queue.isEmpty() && ansSum <= sum - ansSum) {
            int n = queue.poll();
            ansSum += n;
            ans.add(n);
        }
        return ans;
    }


}
