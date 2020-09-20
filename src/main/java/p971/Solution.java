package p971;

import java.util.ArrayList;
import java.util.Collections;
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

    private List<Integer> list = new ArrayList<>();
    private int path = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if (isMatch(root, voyage)) {
            return list;
        } else {
            return Collections.singletonList(-1);
        }
    }

    private boolean isMatch(TreeNode root, int[] voyage) {
        if (root == null) {
            return true;
        }
        if (root.val != voyage[path]) {
            return false;
        }

        path++;

        if (isMatch(root.left, voyage) && isMatch(root.right, voyage)) {
            return true;
        }

        if (isMatch(root.right, voyage) && isMatch(root.left, voyage)) {
            list.add(root.val);
            return true;
        }

        path--;
        return false;
    }
}
