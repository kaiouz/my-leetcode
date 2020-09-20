package ms0410;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        return check(t1, t2, hash(t2)) == -1;
    }

    private int check(TreeNode t1, TreeNode t2, int h) {
        if (t1 == null) {
            return 0;
        }

        int left = check(t1.left, t2, h);
        if (left == -1) {
            return -1;
        }
        int right = check(t1.right, t2, h);
        if (right == -1) {
            return -1;
        }

        int r = t1.val + left + right;
        if (r == h && equal(t1, t2)) {
            return -1;
        } else {
            return r;
        }
    }

    private boolean equal(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 != null && t2 != null) {
            return t1.val == t2.val && equal(t1.left, t2.left) && equal(t1.right, t2.right);
        } else {
            return false;
        }
    }

    private int hash(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + hash(root.left) + hash(root.right);
    }
}
