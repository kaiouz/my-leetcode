package p450;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            return merge(root.left, root.right);
        }

        root.left = deleteNode(root.left, key);
        root.right = deleteNode(root.right, key);
        return root;
    }

    private TreeNode merge(TreeNode left, TreeNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        right.left = merge(left, right.left);
        return right;
    }
}
