package p1261;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class FindElements {

    private TreeNode root;
    Map<Integer, Boolean> cache = new HashMap<>();

    public FindElements(TreeNode root) {
        dfs(root, 0);
        this.root = root;
    }

    private void dfs(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        root.val = val;
        cache.put(val, true);
        dfs(root.left, 2 * val + 1);
        dfs(root.right, 2 * val + 2);
    }

    public boolean find(int target) {
        return cache.getOrDefault(target, Boolean.FALSE);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
