package p1367;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null && head != null) {
            return false;
        }
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode p, TreeNode root) {
        if (p == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (p.val != root.val) {
            return false;
        }
        return dfs(p.next, root.left) || dfs(p.next, root.right);
    }
}
