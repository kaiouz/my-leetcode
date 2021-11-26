package p968;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    public int minCameraCover(TreeNode root) {
        int[] r = helper(root);
        return Math.min(r[0], r[1]);
    }

    private int[] helper(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE / 2, 0, 0};
        }

        int[] left = helper(root.left);
        int[] right = helper(root.right);

        int a = 1 + left[2] + right[2];
        int b = Math.min(a, Math.min(left[0] + right[1], left[1] + right[0]));
        int c = Math.min(b, left[1] + right[1]);
        return new int[]{a, b, c};
    }

}
