package p501;

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

    private Map<Integer, Integer> cache = new HashMap<>();

    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        helper(root);

        for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                list = new ArrayList<>();
                list.add(entry.getKey());
            } else if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }

        int[] ans = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        cache.compute(root.val, (k, v) -> v == null ? 1 : v + 1);
        helper(root.left);
        helper(root.right);
    }

}
