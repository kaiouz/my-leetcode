package p1026;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return max(root, root.val, root.val);
    }

    private int max(TreeNode node, int max, int min) {
        if (node == null) {
            return 0;
        }
        int d = Math.max(Math.abs(node.val - max), Math.abs(node.val - min));
        max = Math.max(max, node.val);
        min = Math.min(min, node.val);
        int dd = Math.max(max(node.left, max, min), max(node.right, max, min));
        return Math.max(d, dd);
    }

    private int[] max(TreeNode root) {
        int[] result = new int[]{0, root.val, root.val};

        if (root.left == null && root.right == null) {
            return result;
        }

        if (root.left != null) {
            int[] left = max(root.left);
            result[0] = Math.max(left[0], Math.max(result[0], Math.max(Math.abs(left[1] - root.val), Math.abs(left[2] - root.val))));
            result[1] = Math.min(left[1], result[1]);
            result[2] = Math.max(left[2], result[2]);
        }

        if (root.right != null) {
            int[] right = max(root.right);
            result[0] = Math.max(right[0], Math.max(result[0], Math.max(Math.abs(right[1] - root.val), Math.abs(right[2] - root.val))));
            result[1] = Math.min(right[1], result[1]);
            result[2] = Math.max(right[2], result[2]);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode n3 = new TreeNode(3);
        TreeNode n0 = new TreeNode(0);
        n0.left = n3;
        TreeNode n2 = new TreeNode(2);
        n2.right = n0;
        TreeNode n1 = new TreeNode(1);
        n1.right = n2;
        System.out.println(new Solution().maxAncestorDiff(n1));
    }
}
