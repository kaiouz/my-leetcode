package p1305;

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

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        helper(root1, list1);
        List<Integer> list2 = new ArrayList<>();
        helper(root2, list2);

        List<Integer> ans = new ArrayList<>(list1.size() + list2.size());
        int i1 = 0, i2 = 0;

        while (i1 < list1.size() || i2 < list2.size()) {
            if (i1 >= list1.size()) {
                ans.add(list2.get(i2++));
            } else if (i2 >= list2.size()) {
                ans.add(list1.get(i1++));
            } else {
                if (list1.get(i1) <= list2.get(i2)) {
                    ans.add(list1.get(i1++));
                } else {
                    ans.add(list2.get(i2++));
                }
            }
        }

        return ans;
    }

    private void helper(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        helper(root.left, ans);
        ans.add(root.val);
        helper(root.right, ans);
    }
}
