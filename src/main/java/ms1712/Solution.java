package ms1712;

import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode convertBiNode(TreeNode root) {
        TreeNode head = new TreeNode(0);
        TreeNode p = head;

        LinkedList<TreeNode> stack = new LinkedList<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.poll();
            root.left = null;
            p.right = root;
            p = p.right;

            root = root.right;
        }

        return head.right;
    }
}
