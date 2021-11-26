package p876;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {

    public ListNode middleNode(ListNode head) {
        ListNode l = head;
        ListNode r = head;

        while (r != null) {
            r = r.next;
            if (r != null) {
                r  = r.next;
            } else {
                break;
            }
            l = l.next;
        }

        return l;
    }

}
