package p671;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    public int findSecondMinimumValue(TreeNode root) {
        return helper(root, root.val);
    }

    private int helper(TreeNode root, int k) {
        if (root.val > k) {
            return root.val;
        }

        if (root.left == null && root.right == null) {
            return -1;
        }

        int left = helper(root.left, k);
        int right = helper(root.right, k);

        if (left != -1 && right != -1) {
            return Math.min(left, right);
        }

        if (left != -1) {
            return left;
        }

        return right;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(Integer.MAX_VALUE);
        n1.left = n2;
        n1.right = n3;
        System.out.println(new Solution().findSecondMinimumValue(n1));
    }
}
