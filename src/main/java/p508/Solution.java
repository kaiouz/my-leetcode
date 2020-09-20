package p508;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Map<Integer, Integer> sums = new HashMap<>();
        helper(root, sums);

        int max = -1;
        List<Integer> list = null;
        for (Map.Entry<Integer, Integer> entry : sums.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                list = new ArrayList<>();
                list.add(entry.getKey());
            } else if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i<list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    private int helper(TreeNode root, Map<Integer, Integer> sums) {
        if (root == null) {
            return 0;
        }

        int sum = root.val + helper(root.left, sums) + helper(root.right, sums);
        int times = sums.getOrDefault(sum, 0);
        sums.put(sum, times + 1);

        return sum;
    }
}
