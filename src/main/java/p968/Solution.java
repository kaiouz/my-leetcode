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
        return Math.min(r[0], r[1] < 0 ? Integer.MAX_VALUE : r[1]);
    }

    private int[] helper(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        if (root.left == null && root.right == null) {
            return new int[]{1, -1};
        }

        int[] left = helper(root.left);
        int[] right = helper(root.right);

        int notset = Math.min(left[0] + (right[1] < 0 ? Integer.MAX_VALUE - right[1] : right[1]),
                right[0] + (left[1] < 0 ? Integer.MAX_VALUE - left[1] : left[1]));
        notset = Math.min(notset, left[0] + right[0]);

        int set = Math.min(left[0], left[1] < 0 ? Integer.MAX_VALUE : left[1])
                + Math.min(right[0], right[1] < 0 ? Integer.MAX_VALUE : right[1]) + 1;
        return new int[]{set, notset};
    }

}
