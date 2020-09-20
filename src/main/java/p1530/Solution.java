package p1530;

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

    int sum = 0;

    public int countPairs(TreeNode root, int distance) {
        paths(root, distance);
        return sum;
    }

    private List<Integer> paths(TreeNode root, int distance) {
        if (root.left == null && root.right == null) {
            List<Integer> res = new ArrayList<>(1);
            res.add(0);
            return res;
        }

        List<Integer> left = root.left != null ? paths(root.left, distance) : Collections.emptyList();
        List<Integer> right = root.right != null ? paths(root.right, distance) : Collections.emptyList();
        List<Integer> result = new ArrayList<>(left.size() + right.size());
        increase(left, result);
        increase(right, result);

        for (Integer l : left) {
            for (Integer r : right) {
                if (l + r <= distance) {
                    sum++;
                }
            }
        }

        return result;
    }

    private void increase(List<Integer> list, List<Integer> result) {
        for (int i = 0; i < list.size(); i++) {
            int s = list.get(i) + 1;
            list.set(i, s);
            result.add(s);
        }
    }

    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2, null, n4);
        TreeNode n3 = new TreeNode(3);
        TreeNode n1 = new TreeNode(1, n2, n3);

        System.out.println(new Solution().countPairs(n1, 3));
    }
}
