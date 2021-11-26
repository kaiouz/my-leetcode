package p445;

import java.util.HashMap;
import java.util.Map;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {

    private Map<ListNode, ListNode> cache = new HashMap<>();

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode t1 = count(l1);
        ListNode t2 = count(l2);

        int cur = 0;

        while (t1 != null || t2 != null || cur > 0) {
            int n1 = 0;
            if (t1 != null) {
                n1 = t1.val;
                t1 = cache.get(t1);
            }
            int n2 = 0;
            if (t2 != null) {
                n2 = t2.val;
                t2 = cache.get(t2);
            }

            ListNode node = new ListNode((n1 + n2 + cur) % 10);
            cur = (n1 + n2 + cur) / 10;
            node.next = head;
            head = node;
        }

        return head;
    }

    private ListNode count(ListNode list) {
        if (list == null) {
            return null;
        }

        while (list.next != null) {
            cache.put(list.next, list);
            list = list.next;
        }

        return list;
    }
}
