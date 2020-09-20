package p111;

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

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        int size = 0;
        int level = 0;

        while ((size = queue.size()) > 0) {
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                if (node.left == null && node.right == null) {
                    return level;
                }
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
        }

        return level;
    }
}
