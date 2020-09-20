package offer26;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }
        if (A == null) {
            return false;
        }
        if (A.val == B.val && equal(A, B)) {
            return true;
        } else {
            return isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }
    }

    private boolean equal(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        } else if (a == null) {
            return false;
        } else if (b == null) {
            return true;
        } else {
            return a.val == b.val && equal(a.left, b.left) && equal(a.right, b.right);
        }
    }


}
