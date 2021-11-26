package p83;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode l = head;
        ListNode r = head.next;

        while (r != null) {
            if (r.val != l.val) {
                l.next = r;
                l = r;
            }
            r = r.next;
        }

        l.next = r;

        return head;
    }


}
