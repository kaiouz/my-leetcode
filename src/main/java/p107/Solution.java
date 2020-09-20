package p107;


import java.util.ArrayList;
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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<List<Integer>> out = new LinkedList<>();
        if (root != null) {
            queue.addLast(root);
        }

        int size = 0;
        while ((size = queue.size()) > 0) {
            List<Integer> line = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                line.add(node.val);
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            out.addFirst(line);
        }

        return out;
    }


}
