package p865;

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
    private int level = 0;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        computeLevel(root, 1);
        return helper(root, 1);
    }

    private void computeLevel(TreeNode root, int l) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            level = Math.max(l, level);
            return;
        }

        computeLevel(root.left, l + 1);
        computeLevel(root.right, l + 1);
    }

    private TreeNode helper(TreeNode root, int l) {
        if (root == null) {
            return null;
        }

        if (l == level) {
            return root;
        }

        TreeNode left = helper(root.left, l + 1);
        TreeNode right = helper(root.right, l + 1);

        if (left == null && right == null) {
            return null;
        }

        if (left != null && right != null) {
            return root;
        }

        if (left != null) {
            return left;
        }

        return right;
    }
}
