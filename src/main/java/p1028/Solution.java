package p1028;


import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


class Solution {

    public TreeNode recoverFromPreorder(String S) {
        int[] index = {0};
        LinkedList<TreeNode> stack = new LinkedList<>();
        int level = 0;
        TreeNode root = null;
        TreeNode parent = null;

        while (index[0] < S.length()) {
            TreeNode node = new TreeNode(parseVal(S, index));

            if (parent == null) {
                root = node;
            } else {
                if (parent.left == null) {
                    parent.left = node;
                } else if (parent.right == null) {
                    parent.right = node;
                } else {
                    // 不可能
                }
            }

            int nextLevel = parseLevel(S, index);
            if (nextLevel > level) {
                stack.push(parent);
                parent = node;
                level++;
            } else {
                while (nextLevel < level) {
                    parent = stack.pop();
                    level--;
                }
            }
        }

        return root;
    }

    private int parseVal(String s, int[] index) {
        int start = index[0];
        for (; index[0] < s.length() && s.charAt(index[0]) != '-'; index[0]++) ;
        return Integer.parseInt(s.substring(start, index[0]));
    }

    private int parseLevel(String s, int[] index) {
        int start = index[0];
        for (; index[0] < s.length() && s.charAt(index[0]) == '-'; index[0]++) ;
        return index[0] - start;
    }
}
