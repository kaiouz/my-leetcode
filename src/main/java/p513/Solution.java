package p513;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    private int lev;
    private int v;

    public int findBottomLeftValue(TreeNode root) {
        helper(root, 1);
        return v;
    }

    private void helper(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (level > lev) {
            lev = level;
            v = root.val;
        }

        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
}
