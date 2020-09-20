package leetcode;

public class Problem2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1, q = l2;
        ListNode head = new ListNode(0), cur = head;

        // 进位
        int n = 0;
        while (p != null && q != null) {
            int v = p.val + q.val + n;
            n = v / 10;
            cur.next = new ListNode(v % 10);
            cur = cur.next;
            p = p.next;
            q = q.next;
        }

        ListNode l = p != null ? p : q;
        while (l != null) {
            int v = l.val + n;
            n = v / 10;
            cur.next = new ListNode(v % 10);
            cur = cur.next;
            l = l.next;
        }

        if (n > 0) {
            cur.next = new ListNode(n);
        }

        return head.next;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
