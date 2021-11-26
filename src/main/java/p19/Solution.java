package p19;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0);
        temp.next = head;

        ListNode l = temp, r = temp;
        int i = 0;
        while (r != null) {
            r = r.next;
            if (i++ > n) {
                l = l.next;
            }
        }

        l.next = l.next.next;

        return temp.next;
    }

}
