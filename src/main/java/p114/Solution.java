package p114;

import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    public void flatten(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();

        stack.push(root);

        TreeNode head = new TreeNode();

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            while (node != null) {
                head.right = node;
                head = node;
                if (node.right != null) {
                    stack.push(node.right);
                }
                node = node.left;
                head.left = null;
            }
        }
    }

}
