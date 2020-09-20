package p655;

import java.util.ArrayList;
import java.util.Arrays;
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

    public List<List<String>> printTree(TreeNode root) {
        int h = height(root);
        int size = (1 << h) - 1;

        List<List<String>> out = new ArrayList<>(h);
        for (int i = 0; i < h; i++) {
            List<String> list = new ArrayList<>(size);
            for (int j = 0; j < size; j++) {
                list.add("");
            }
            out.add(list);
        }

        fill(root, out, 0, 0, size);

        return out;
    }

    private void fill(TreeNode root, List<List<String>> out, int level, int start, int end) {
        if (root == null) {
            return;
        }

        int mid = (start + end) / 2;
        out.get(level).set(mid, String.valueOf(root.val));

        fill(root.left, out, level + 1, start, mid);
        fill(root.right, out, level + 1, mid+1, end);
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
