package p687;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    private int sum = 0;


    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return sum;
    }

    private int[] helper(TreeNode root) {
        if (root == null) {
            return new int[]{-1, 0};
        }

        int[] left = helper(root.left);
        int[] right = helper(root.right);

        if (left[0] == root.val && right[0] == root.val) {
            sum = Math.max(sum, left[1] + right[1]);
            return new int[]{root.val, Math.max(left[1], right[1]) + 1};
        } else if (left[0] == root.val) {
            sum = Math.max(sum, left[1]++);
            return left;
        } else if (right[0] == root.val) {
            sum = Math.max(sum, right[1]++);
            return right;
        } else {
            return new int[]{root.val, 1};
        }
    }
}
