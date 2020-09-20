package p623;

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

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode n = new TreeNode(v);
            n.left = root;
            return n;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        int level = 0;
        int size = 0;
        int dd = d - 1;
        while ((size = queue.size()) > 0) {
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                if (level == dd) {
                    TreeNode nl = new TreeNode(v);
                    nl.left = node.left;
                    node.left = nl;
                    TreeNode nr = new TreeNode(v);
                    nr.right = node.right;
                    node.right = nr;
                } else {
                    if (node.left != null) {
                        queue.addLast(node.left);
                    }
                    if (node.right != null) {
                        queue.addLast(node.right);
                    }
                }
            }
        }

        return root;
    }


}
