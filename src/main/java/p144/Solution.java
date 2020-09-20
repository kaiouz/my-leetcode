package p144;

import java.util.LinkedList;
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

    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();

        LinkedList<Integer> out = new LinkedList<>();

        stack.push(root);
        TreeNode node = null;

        while (!stack.isEmpty()) {
            node = stack.pop();
            while (node != null) {
                out.add(node.val);
                if (node.right != null) {
                    stack.push(node.right);
                }
                node = node.left;
            }
        }

        return out;
    }

}
