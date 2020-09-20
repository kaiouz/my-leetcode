package p129;

import java.math.BigInteger;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    int res = 0;

    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode root, int n) {
        if (root == null) {
            return;
        }

        n = n * 10 + root.val;

        if (root.left == null && root.right == null) {
            res += n;
        } else {
            helper(root.left, n);
            helper(root.right, n);
        }
    }
}
