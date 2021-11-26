package ms0205;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;

        int curry = 0;

        while (l1 != null || l2 != null || curry > 0) {
            int n1 = 0;
            if (l1 != null) {
                n1 = l1.val;
                l1 = l1.next;
            }
            int n2 = 0;
            if (l2 != null) {
                n2 = l2.val;
                l2 = l2.next;
            }
            ListNode temp = new ListNode((n1 + n2 + curry) % 10);
            curry = (n1 + n2 + curry) / 10;
            tail.next = temp;
            tail = tail.next;
        }

        return head.next;
    }

}
