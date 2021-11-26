package p328;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode l = head;
        ListNode r = head.next;

        while (r != null && r.next != null) {
            ListNode temp = r.next;
            r.next = temp.next;
            r = r.next;

            temp.next = l.next;
            l.next = temp;
            l = l.next;
        }

        return head;
    }

}
