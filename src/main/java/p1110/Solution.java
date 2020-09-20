package p1110;

import java.util.*;
import java.util.stream.Collectors;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> deletes = new HashSet<>();
        for (int delete : to_delete) {
            deletes.add(delete);
        }

        Map<TreeNode, Boolean> nodes = new HashMap<>();
        trees(null, false, root, deletes, nodes);
        for (TreeNode node : nodes.keySet()) {
            iter(node.left, nodes);
            iter(node.right, nodes);
        }

        return nodes.entrySet().stream()
                .filter(entry -> !entry.getValue())
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }

    private void iter(TreeNode root, Map<TreeNode, Boolean> nodes) {
        if (root == null) {
            return;
        }
        nodes.put(root, true);
        iter(root.left, nodes);
        iter(root.right, nodes);
    }

    private void trees(TreeNode parent, boolean left, TreeNode node, Set<Integer> deletes, Map<TreeNode, Boolean> tree) {
        if (node == null) {
            return;
        }
        if (deletes.contains(node.val)) {
            if (parent != null) {
                if (left) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
            parent = null;
        } else {
            tree.put(node,false);
            parent = node;
        }
        trees(parent, true, node.left, deletes, tree);
        trees(parent, false, node.right, deletes, tree);
    }

}
