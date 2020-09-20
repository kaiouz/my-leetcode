package p897;

import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    public TreeNode increasingBST(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();

        TreeNode head = new TreeNode(0);
        TreeNode cur = head;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode n = stack.pop();
            cur.right = n;
            cur = cur.right;

            n.left = null;
            root = n.right;
        }

        return head.right;
    }

}
