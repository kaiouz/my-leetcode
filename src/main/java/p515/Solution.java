package p515;

import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, 0, ans);
        return ans;
    }

    private void helper(TreeNode node, int level, List<Integer> max) {
        if (node == null) {
            return;
        }

        if (level >= max.size()) {
            max.add(node.val);
        } else {
            max.set(level, Math.max(max.get(level), node.val));
        }

        helper(node.left, level+1, max);
        helper(node.right, level+1, max);
    }
}
