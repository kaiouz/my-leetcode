package p1339;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    private int mid = 0;
    private int max = Integer.MAX_VALUE;
    private int sum;

    public static final long MOD = 1000000007;

    public int maxProduct(TreeNode root) {
        sum = sum(root);
        find(root);

        return (int) (((mid % MOD) * ((sum - mid) % MOD)) % MOD);
    }

    private int find(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = find(root.left);
        int right = find(root.right);

        if (Math.abs(left - (sum - left)) < max) {
            mid = left;
            max = Math.abs(left - (sum - left));
        }

        if (Math.abs(right - (sum - right)) < max) {
            mid = right;
            max = Math.abs(right - (sum - right));
        }

        return root.val + left + right;
    }

    private int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + sum(root.left) + sum(root.right);
    }
}
