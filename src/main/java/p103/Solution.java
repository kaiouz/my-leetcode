package p103;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int size = 0;

        int l = 0;

        List<List<Integer>> out = new LinkedList<>();

        while((size = queue.size()) > 0) {
            List<Integer> list = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                list.add(node.val);

                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            l = ++l % 2;
            if (l == 0) {
                Collections.reverse(list);
            }

            out.add(list);
        }

        return out;
    }
}
