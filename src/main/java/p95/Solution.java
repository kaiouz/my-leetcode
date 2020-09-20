package p95;

import java.util.ArrayList;
import java.util.Collections;
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

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return Collections.emptyList();
        }
        return genTrees(1, n);
    }

    private List<TreeNode> genTrees(int start, int end) {
        if (start > end) {
            return Collections.singletonList(null);
        }
        List<TreeNode> trees = new LinkedList<>();
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = genTrees(start, i - 1);
            List<TreeNode> right = genTrees(i + 1, end);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    trees.add(new TreeNode(i, l, r));
                }
            }
        }
        return trees;
    }

    public static void main(String[] args) {
        new Solution().generateTrees(3);
    }
}
