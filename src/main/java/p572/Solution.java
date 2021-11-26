package p572;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return helper(s, t);
    }

    private boolean helper(TreeNode s, TreeNode t) {
        if (s == null) {
            return t == null;
        }

        if (s.val == t.val && equal(s, t)) {
            return true;
        }

        return helper(s.left, t) || helper(s.right, t);
    }

    private boolean equal(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s != null && t != null) {
            return s.val == t.val && equal(s.left, t.left) && equal(s.right, t.right);
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        TreeNode s = genTree(new Integer[]{3, 4, 5, 1, 2, null, null, 0});
        TreeNode t = genTree(new Integer[]{4, 1, 2});
        System.out.println(new Solution().isSubtree(s, t));
    }

    private static TreeNode genTree(Integer[] vals) {
        List<TreeNode> out = new ArrayList<>();
        int i = 0;
        int prev = -1;

        for (Integer val : vals) {
            TreeNode node = val == null ? null : new TreeNode(val);
            if (i < out.size()) {
                TreeNode t = out.get(i);
                if (i > prev) {
                    t.left = node;
                    prev = i;
                } else {
                    t.right = node;
                    i++;
                }
            }
            if (node != null) {
                out.add(node);
            }
        }

        return out.isEmpty() ? null : out.get(0);
    }

}
