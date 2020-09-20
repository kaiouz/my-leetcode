package p543;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        max = Math.max(max, left + right);
        if (left > right) {
            return left + 1;
        } else {
            return right + 1;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        n1.right = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        n1.left = n2;

        n2.left = new TreeNode(4);
        n2.right = new TreeNode(5);

        System.out.println(new Solution().diameterOfBinaryTree(n1));
    }
}
