package p654;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return maxTree(nums, 0, nums.length);
    }

    private TreeNode maxTree(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }
        int max = maxIndex(nums, start, end);
        TreeNode node = new TreeNode(nums[max]);
        node.left = maxTree(nums, start, max);
        node.right = maxTree(nums, max + 1, end);
        return node;
    }

    private int maxIndex(int[] nums, int start, int end) {
        int max = start;
        for (int i = start; i < end; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        return max;
    }
}
