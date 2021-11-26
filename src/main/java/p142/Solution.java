package p142;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;

        while (fast != null) {
            fast = fast.next;
            if (fast == null) {
                break;
            }
            fast = fast.next;
            slow = slow.next;

            if (fast == slow) {
                break;
            }
        }

        if (fast != slow) {
            return null;
        }

        fast = head;

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }

}
