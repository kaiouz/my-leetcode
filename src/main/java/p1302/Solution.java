package p1302;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    public int deepestLeavesSum(TreeNode root) {
        return dfs(root)[1];
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        if (root.left == null && root.right == null) {
            return new int[]{1, root.val};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        if (left[0] == right[0]) {
            return new int[]{left[0] + 1, left[1] + right[1]};
        } else if (left[0] > right[0]) {
            return new int[]{left[0] + 1, left[1]};
        } else {
            return new int[]{right[0] + 1, right[1]};
        }
    }
}
