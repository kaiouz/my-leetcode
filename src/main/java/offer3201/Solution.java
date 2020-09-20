package offer3201;


import java.util.ArrayList;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public int[] levelOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.addLast(root);
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            list.add(node.val);
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
