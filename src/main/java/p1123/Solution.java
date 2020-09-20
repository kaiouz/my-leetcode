package p1123;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) {
            return null;
        }
        return helper(root).node;
    }

    private Item helper(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new Item(root, 1);
        }

        Item left = root.left != null ? helper(root.left) : null;
        Item right = root.right != null ? helper(root.right) : null;

        if (left == null) {
            right.depth++;
            return right;
        }

        if (right == null) {
            left.depth++;
            return left;
        }

        if (left.depth > right.depth) {
            left.depth++;
            return left;
        } else if (left.depth < right.depth) {
            right.depth++;
            return right;
        } else {
            return new Item(root, right.depth + 1);
        }
    }

    static class Item {
        public Item(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }

        TreeNode node;
        int depth;
    }
}
