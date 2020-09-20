package ms0412;

import java.util.HashMap;
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
    private int count = 0;

    private Map<Integer, Integer> map = new HashMap<>();

    public int pathSum(TreeNode root, int sum) {
        helper(root, 0, sum);
        map.put(0, 0);
        return count;
    }

    private void helper(TreeNode root, int s, int sum) {
        if (root == null) {
            return;
        }

        s += root.val;

        count += map.getOrDefault(s - sum, 0);

        map.compute(s, (k, v) -> v == null ? 1 : v + 1);

        helper(root.left, s, sum);
        helper(root.right, s, sum);


        map.compute(s, (k, v) -> v - 1);
    }

}
