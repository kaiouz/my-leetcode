package p86;

 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {

    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0);
        ListNode smallTail = smallHead;
        ListNode bigHead = new ListNode(0);
        ListNode bigTail = bigHead;

        ListNode p = head;
        while (p != null) {
            if (p.val < x) {
                smallTail.next = p;
                smallTail = smallTail.next;
            } else {
                bigTail.next = p;
                bigTail = bigTail.next;
            }
            p = p.next;
        }
        smallTail.next = bigHead.next;
        bigTail.next = null;

        return smallHead.next;
    }

}
