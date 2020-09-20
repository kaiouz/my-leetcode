package p104;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    private int max = 0;

    public int maxDepth(TreeNode root) {
        maxDepth(root, 0);
        return max;
    }

    private void maxDepth(TreeNode root, int path) {
        if (root == null) {
            max = Math.max(path, max);
           return;
        }

        maxDepth(root.left, path+1);
        maxDepth(root.right, path+1);
    }
}
