package p337;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    public int rob(TreeNode root) {
        int[] max = maxRob(root);
        return Math.max(max[0], max[1]);
    }

    private int[] maxRob(TreeNode parent) {
        if (parent == null) {
            return new int[]{0, 0};
        }

        int[] left = maxRob(parent.left);
        int[] right = maxRob(parent.right);

        return new int[]{
                parent.val + left[1] + right[1],
                Math.max(left[0], left[1]) + Math.max(right[0], right[1])
        };
    }


}
