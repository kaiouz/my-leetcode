package p652;


import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<Integer, TreeNode> map = new HashMap<>();
        find(root, map, new HashMap<>());
        return new ArrayList<>(map.values());
    }

    private void find(TreeNode root, Map<Integer, TreeNode> nodes, Map<Integer, List<TreeNode>> map) {
        if (root == null) {
            return;
        }

        List<TreeNode> same = map.computeIfAbsent(root.val, k -> new ArrayList<>());
        for (TreeNode n : same) {
            if (equal(n, root)) {
                nodes.put(n.val, n);
                break;
            }
        }

        same.add(root);
        find(root.left, nodes, map);
        find(root.right, nodes, map);
    }

    private boolean equal(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        } else {
            return root1.val == root2.val && equal(root1.left, root2.left) && equal(root1.right, root2.right);
        }
    }
}
