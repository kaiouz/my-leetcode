package p105;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, inorder, 0, inorder.length);
    }

    private TreeNode helper(int[] preorder, int i, int[] inorder, int start, int end) {
        if (i >= preorder.length || start >= end) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[i]);

        int index = -1;
        for (int j = start; j < end; j++) {
            if (inorder[j] == preorder[i]) {
                index = j;
                break;
            }
        }

        node.left = helper(preorder, i + 1, inorder, start, index);
        node.right = helper(preorder, i + 1 + index - start, inorder, index + 1, end);

        return node;
    }
}
