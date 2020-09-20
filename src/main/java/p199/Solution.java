package p199;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    private List<Integer> list = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        helper(root, 1);
        return list;
    }

    private void helper(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level > list.size()) {
            list.add(root.val);
        }
        if (root.right != null) {
            helper(root.right, level + 1);
        }
        if (root.left != null) {
            helper(root.left, level + 1);
        }
    }

}
