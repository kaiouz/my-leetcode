package p404;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    public int sumOfLeftLeaves(TreeNode root) {
        return sum(root, false);
    }

    public  int sum(TreeNode root, boolean left) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return left ? root.val : 0;
        }

        return sum(root.left, true) + sum(root.right, false);
    }
}
