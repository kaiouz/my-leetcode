package p106;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int poStart, int poEnd) {
        if (inStart > inEnd) {
            return null;
        }

        TreeNode node = new TreeNode(postorder[poEnd]);
        int mid = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == postorder[poEnd]) {
                mid = i;
                break;
            }
        }

        node.left = helper(inorder, inStart, mid - 1, postorder, poStart, poStart + mid - inStart-1);
        node.right = helper(inorder, mid + 1, inEnd, postorder, poStart + mid - inStart, poEnd - 1);

        return node;
    }


    public static void main(String[] args) {
        new Solution().buildTree(
                new int[]{9,3,15,20,7},
                new int[]{9,15,7,20,3}
        );
    }
}
