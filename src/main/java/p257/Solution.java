package p257;

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
    private LinkedList<String> path = new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        paths(root, "");
        return path;
    }

    private void paths(TreeNode root, String p) {
        p = p.isEmpty() ? p : p + "->";
        p = p + root.val;

        if (root.left == null && root.right == null) {
            path.add(p);
            return;
        }

        if (root.left != null) {
            paths(root.left, p);
        }
        if (root.right != null) {
            paths(root.right, p);
        }
    }
}
