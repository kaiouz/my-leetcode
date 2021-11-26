package p701;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {


    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode p = root;

        while (p != null) {
            if (val > p.val) {
                if (p.right == null) {
                    p.right = new TreeNode(val);
                    return root;
                } else {
                    p = p.right;
                }
            } else if (val < p.val) {
                if (p.left == null) {
                    p.left = new TreeNode(val);
                    return root;
                } else {
                    p = p.left;
                }
            }
        }

        return new TreeNode(val);
    }


}
