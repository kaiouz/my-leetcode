package p112;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == sum;
        }

        int next = sum - root.val;

        boolean find = false;
        if (root.left != null) {
            find = hasPathSum(root.left, next);
        }

        if (!find && root.right != null) {
            find = hasPathSum(root.right, next);
        }
        return find;
    }
}
