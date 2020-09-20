package p109;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

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

    public TreeNode sortedListToBST(ListNode head) {
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        return bst(head, length);
    }

    private TreeNode bst(ListNode head, int length) {
        if (length <= 0) {
            return null;
        }
        int mid = length / 2 + 1;
        ListNode node = head;
        for (int i = 1; i < mid; i++) {
            node = node.next;
        }

        TreeNode root = new TreeNode(node.val);
        root.left = bst(head, mid - 1);
        root.right = bst(node.next, length - mid);
        return root;
    }

}
