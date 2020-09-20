package p1022;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    int result = 0;
    final int MOD = 1000000007;

    public int sumRootToLeaf(TreeNode root) {
        sum(root, 0);
        return result;
    }

    private void sum(TreeNode root, int s) {
        if (root == null) {
            return;
        }

        s = ((s << 1) % MOD + root.val) % MOD;

        if (root.left == null && root.right == null) {
            result = (result + s) % MOD;
        }

        sum(root.left, s);
        sum(root.right, s);
    }
}
