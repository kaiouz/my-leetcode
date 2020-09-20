package p113;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> temp = new ArrayList<>();
        helper(root, 0, sum, ans, temp);
        return ans;
    }

    private void helper(TreeNode root, int cur, int sum, List<List<Integer>> ans, List<Integer> temp) {
        if (root == null) {
            return;
        }

        cur += root.val;
        temp.add(root.val);
        if (root.left == null && root.right == null && cur == sum) {
            ans.add(new ArrayList<>(temp));
        }

        helper(root.left, cur, sum, ans, temp);
        helper(root.right, cur, sum, ans, temp);
        temp.remove(temp.size() - 1);
    }
}
