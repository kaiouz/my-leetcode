package p1315;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    public int sumEvenGrandparent(TreeNode root) {
        return sumEvenGp(null, null, root);
    }

    private int sumEvenGp(TreeNode gp, TreeNode parent, TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = gp == null ? 0 : gp.val % 2 == 0 ? root.val : 0;
        return sumEvenGp(parent, root, root.left) + sumEvenGp(parent, root, root.right) + sum;
    }
}
