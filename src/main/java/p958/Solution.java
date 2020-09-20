package p958;

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

    public boolean isCompleteTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList();
        queue.addLast(root);

        TreeNode node = null;
        boolean last = false;
        while ((node = queue.pollFirst()) != null) {
            if (last) {
                if (node.left != null || node.right != null) {
                   return false;
                }
            } else {
                if (node.left == null) {
                    if (node.right != null) {
                        return false;
                    }
                    last = true;
                } else {
                    queue.addLast(node.left);
                   if (node.right != null) {
                       queue.addLast(node.right);
                   } else {
                       last = true;
                   }
                }
            }
        }

        return true;
    }


}
