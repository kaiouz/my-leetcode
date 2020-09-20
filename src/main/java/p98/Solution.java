package p98;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    private int val = Integer.MIN_VALUE;
    private boolean start = false;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!isValidBST(root.left)) {
            return false;
        }

        if (start && root.val <= val) {
            return false;
        }

        start = true;
        val = root.val;

        return isValidBST(root.right);
    }
}
