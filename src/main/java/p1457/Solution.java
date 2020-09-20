package p1457;

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

    public int pseudoPalindromicPaths(TreeNode root) {
        return pseudoPalindromicPaths(root, new int[10]);
    }

    private int pseudoPalindromicPaths(TreeNode root, int[] count) {
        count[root.val]++;
        if (root.left == null && root.right == null) {
            int nums = 0;
            for (int i = 0; i < count.length; i++) {
                if (count[i] % 2 == 1) {
                    nums++;
                }
            }
            count[root.val]--;
            return nums <= 1 ? 1 : 0;
        }
        int left = root.left != null ? pseudoPalindromicPaths(root.left, count) : 0;
        int right = root.right != null ? pseudoPalindromicPaths(root.right, count) : 0;
        count[root.val]--;

        return left + right;
    }
}
