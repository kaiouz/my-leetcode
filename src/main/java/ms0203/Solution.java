package ms0203;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public void deleteNode(ListNode node) {
        ListNode p = node.next;
        node.val = p.val;

        while (p.next != null) {
            p = p.next;
            node = node.next;
            node.val = p.val;
        }

        node.next = null;
    }
}
