package p1008;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    private int cur;

    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode helper(int[] preorder, int low, int high) {
        if (cur >= preorder.length) {
            return null;
        }

        if (preorder[cur] > low && preorder[cur] < high) {
            TreeNode node = new TreeNode(preorder[cur++]);
            node.left = helper(preorder, low, node.val);
            node.right = helper(preorder, node.val, high);
            return node;
        } else {
            return null;
        }

    }

}
