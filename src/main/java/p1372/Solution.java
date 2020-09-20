package p1372;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    private int max = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        max = Math.max(maxZig(root.left, false)+1, max);
        max = Math.max(maxZig(root.right, true)+1, max);
        return max - 1 ;
    }

    private int maxZig(TreeNode root, boolean direct) {
        if (root == null) {
            return 0;
        }

        int left = maxZig(root.left, false) + 1;
        int right = maxZig(root.right, true) + 1;
        max = Math.max(max, left);
        max = Math.max(max, right);

        return direct ? left : right;
    }

}
