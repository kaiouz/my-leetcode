package offer32;

import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        int size = 0;
        boolean dir = true;

        LinkedList<List<Integer>> out = new LinkedList<>();

        while ((size = queue.size()) > 0) {
            LinkedList<Integer> list = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                if (dir) {
                    list.addLast(node.val);
                } else {
                    list.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            out.addLast(list);
            dir = !dir;
        }
        return out;
    }
}
