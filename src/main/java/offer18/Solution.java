package offer18;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode temp = new ListNode(0);
        temp.next = head;

        ListNode p = temp;

        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
                break;
            }
            p = p.next;
        }

        return temp.next;
    }
}
