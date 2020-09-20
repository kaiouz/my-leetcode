package p919;

import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class CBTInserter {

    private TreeNode root;

    private LinkedList<TreeNode> queue = new LinkedList<>();

    private TreeNode next;

    public CBTInserter(TreeNode root) {
        this.root = root;

        queue.addLast(root);

        while (!queue.isEmpty()) {
            next = queue.pollFirst();
            if (next.left == null) {
                break;
            } else {
                queue.addLast(next.left);
            }
            if (next.right == null) {
                break;
            } else {
                queue.addLast(next.right);
            }
        }
    }

    public int insert(int v) {
        if (next.left == null) {
            next.left = new TreeNode(v);
            queue.addLast(next.left);
            return next.val;
        }
        next.right = new TreeNode(v);
        queue.addLast(next.right);
        int r = next.val;
        next = queue.pollFirst();
        return r;
    }

    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */
