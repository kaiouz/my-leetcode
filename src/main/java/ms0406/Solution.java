package ms0406;

import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode node = root;
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (node != null) {
            if (p.val < node.val) {
                stack.push(node);
                node = node.left;
            } else if (p.val > node.val) {
                node = node.right;
            } else {
                break;
            }
        }

        if (node.right != null) {
            TreeNode mostLeft = node.right;
            while (mostLeft.left != null) {
                mostLeft = mostLeft.left;
            }
            return mostLeft;
        }

        return stack.pollFirst();
    }
}
