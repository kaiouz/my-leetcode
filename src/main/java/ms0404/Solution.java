package ms0404;

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
        return checkHeight(root)[0] == 1;
    }

    private int[] checkHeight(TreeNode node) {
        if (node == null) {
            return new int[]{1, 0};
        }

        int[] left = checkHeight(node.left);
        if (left[0] == 0) {
            return new int[]{0, 0};
        }

        int[] right = checkHeight(node.right);
        if (right[0] == 0) {
            return new int[]{0, 0};
        }

        return Math.abs(left[1] - right[1]) <= 1 ? new int[]{1, Math.max(left[1], right[1]) + 1} : new int[]{0, 0};
    }


}
