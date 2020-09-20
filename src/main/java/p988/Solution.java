package p988;

import java.util.Iterator;
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
    private char[] min;

    public String smallestFromLeaf(TreeNode root) {
        helper(root, new LinkedList<>());
        return new String(min);
    }

    private void helper(TreeNode root, LinkedList<Character> list) {
        if (root == null) {
            return;
        }
        list.addFirst((char) (root.val + 'a'));
        if (root.left == null && root.right == null) {
            minStr(list);
        } else {
            if (root.left != null) {
                helper(root.left, list);
            }
            if (root.right != null) {
                helper(root.right, list);
            }
        }
        list.removeFirst();
    }

    private void minStr(LinkedList<Character> list) {
        if (isReplace(list)) {
            char[] s = new char[list.size()];
            int i = 0;
            for (Character c : list) {
                s[i++] = c;
            }
            min = s;
        }
    }

    private boolean isReplace(LinkedList<Character> list) {
        if (min != null) {
            int len = Math.min(min.length, list.size());
            Iterator<Character> iterator = list.iterator();
            for (int i = 0; i < len; i++) {
                char c = iterator.next();
                if (min[i] < c) {
                    return false;
                } else if (min[i] > c) {
                    return true;
                }
            }
            return min.length > list.size();
        }
        return true;
    }


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(25);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(3);
        n2.left = n4;
        n2.right = n5;
        TreeNode n6 = new TreeNode(0);
        TreeNode n7 = new TreeNode(2);
        n3.left = n6;
        n3.right = n7;
        System.out.println(new Solution().smallestFromLeaf(n1));
    }
}
