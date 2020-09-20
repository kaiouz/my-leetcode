package p783;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    private int min = Integer.MAX_VALUE;

    private int prev = 0;

    private boolean hasPrev = false;

    public int minDiffInBST(TreeNode root) {
        helper(root);
        return min;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            helper(root.left);
        }

        if (hasPrev) {
            min = Math.min(min, root.val - prev);
        } else {
            hasPrev = true;
        }
        prev = root.val;

        if (root.right != null) {
            helper(root.right);
        }
    }

}
