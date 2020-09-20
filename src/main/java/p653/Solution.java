package p653;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    private Map<Integer, Boolean> cache = new HashMap<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root != null) {
            return false;
        }

        int target = k - root.val;
        if (cache.getOrDefault(target, false)) {
            return true;
        }
        cache.put(root.val, true);

        return findTarget(root.left, k) && findTarget(root.right, k);
    }

}
