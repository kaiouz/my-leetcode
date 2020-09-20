package ms0409;

import java.util.ArrayList;
import java.util.Collections;
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
    public List<List<Integer>> BSTSequences(TreeNode root) {
        return helper(root);
    }

    private List<List<Integer>> helper(TreeNode node) {
        if (node == null) {
            return Collections.singletonList(Collections.emptyList());
        }

        List<List<Integer>> left = helper(node.left);
        List<List<Integer>> right = helper(node.right);

        List<List<Integer>> out = new LinkedList<>();
        List<Integer> temp = new ArrayList<>(1 + left.get(0).size() + right.get(0).size());
        temp.add(node.val);

        for (List<Integer> l : left) {
            for (List<Integer> r : right) {
                compose(out, temp, l, 0, r, 0);
            }
        }

        return out;
    }

    private void compose(List<List<Integer>> out, List<Integer> temp, List<Integer> list1, int idx1, List<Integer> list2, int idx2) {
        if (idx1 >= list1.size() && idx2 >= list2.size()) {
            out.add(new ArrayList<>(temp));
            return;
        }

        if (idx1 < list1.size()) {
            temp.add(list1.get(idx1));
            compose(out, temp, list1, idx1 + 1, list2, idx2);
            temp.remove(temp.size() - 1);
        }

        if (idx2 < list2.size()) {
            temp.add(list2.get(idx2));
            compose(out, temp, list1, idx1, list2, idx2 + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
