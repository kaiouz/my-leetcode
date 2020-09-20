package p437;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> sums = new HashMap<>();
        sums.put(0, 1);
        return pathSum(root, sum, 0, sums);
    }

    private int pathSum(TreeNode node, int target, int sum, Map<Integer, Integer> sums) {
        if (node == null) {
            return 0;
        }

        sum += node.val;
        int count = sums.getOrDefault(sum - target, 0);

        sums.put(sum, sums.getOrDefault(sum, 0) + 1);
        int left = pathSum(node.left, target, sum, sums);
        int right = pathSum(node.right, target, sum, sums);
        sums.put(sum, sums.get(sum) - 1);
        return count + left + right;
    }
}
