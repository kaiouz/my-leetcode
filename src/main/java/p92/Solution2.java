package p92;

public class Solution2 {

    int i = 0;

    private ListNode last;

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ++i;
        if (i < m) {
            head.next = reverseBetween(head.next, m, n);
            return head;
        } else if (i < n) {
            ListNode p = reverseBetween(head, m, n);
            head.next.next = head;
            head.next = last;
            return p;
        } else if (i == n) {
            last = head.next;
            return head;
        } else {
            return head;
        }
    }


    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(5);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;

        new Solution().reverseBetween(p1, 2, 4);
        print(p1);
    }

     static void print(ListNode node) {
        ListNode p = node;
        while (p != null) {
            System.out.print(p.val);
            System.out.print(',');
            p = p.next;
        }
    }
}
