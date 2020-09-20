package p863;

import java.util.ArrayList;
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

    private List<Integer> res = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        helper(root, target.val, K, -1);
        return res;
    }

    private int helper(TreeNode root, int target, int k, int n) {
        if (root == null) {
            return -1;
        }

        if (n == k) {
            res.add(root.val);
            return -1;
        }

        if (root.val == target) {
            if (k == 0) {
                res.add(root.val);
            } else {
                helper(root.left, target, k, 1);
                helper(root.right, target, k, 1);
            }
            return 1;
        } else {
            if (n > 0) {
                helper(root.left, target, k, n + 1);
                helper(root.right, target, k, n + 1);
                return -1;
            } else {
                int left = helper(root.left, target, k, n);
                if (left > 0) {
                    if (left == k) {
                        res.add(root.val);
                    } else if (left < k) {
                        helper(root.right, target, k, left+1);
                    }
                    return left + 1;
                }
                int right = helper(root.right, target, k, n);
                if (right > 0) {
                    if (right == k) {
                        res.add(root.val);
                    } else if (right < k) {
                        helper(root.left, target, k, right+1);
                    }
                    return right + 1;
                }
                return -1;
            }
        }

    }
}
