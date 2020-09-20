package p110;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    public boolean isBalanced(TreeNode root) {
        return height(root)[0] == 1;
    }

    private int[] height(TreeNode root) {
        if (root == null) {
            return new int[]{1, 0};
        }

        int[] left = height(root.left);
        if (left[0] == 0) {
            return new int[]{0, 0};
        }

        int[] right = height(root.right);
        if (right[0] == 0) {
            return new int[]{0, 0};
        }

        if (Math.abs(left[1] - right[1]) > 1) {
            return new int[]{0, 0};
        } else {
            return new int[]{1, Math.max(left[1], right[1])};
        }

    }

}
