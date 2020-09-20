package p1148;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    private int sum = 0;

    public int goodNodes(TreeNode root) {
        helper(root, Integer.MIN_VALUE);
        return sum;
    }

    private void helper(TreeNode root, int max) {
        if (root == null) {
            return;
        }

        if (root.val >= max) {
            sum++;
        }

        max = Math.max(max, root.val);
        helper(root.left, max);
        helper(root.right, max);
    }

}
