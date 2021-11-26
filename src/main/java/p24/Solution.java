package p24;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode nh = new ListNode(0);
        nh.next = head;

        ListNode p1 = nh, p2 = head.next;

        int n = 0;
        while (p2 != null) {
            if (n == 0) {
                p1.next.next = p2.next;
                p2.next = p1.next;
                p1.next = p2;
                p2 = p2.next;
            }
            p1 = p1.next;
            p2 = p2.next;
            n = (n + 1) % 2;
        }

        return nh.next;
    }

}
