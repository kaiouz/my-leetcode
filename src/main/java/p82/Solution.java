package p82;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {

    public ListNode deleteDuplicates(ListNode head) {
       return helper(head, false);
    }

    private ListNode helper(ListNode head, boolean prev) {
        if (head == null) {
            return null;
        }

        if (prev) {
            return helper(head.next, head.next != null && head.next.val == head.val);
        } else {
            if (head.next != null && head.next.val == head.val) {
               return helper(head.next, true);
            } else {
                head.next = helper(head.next, false);
                return head;
            }
        }
    }

}
