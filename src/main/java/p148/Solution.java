package p148;


class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ListNode sortList(ListNode head) {
        return sort(head, null);
    }

    private ListNode sort(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
        if (head == tail) {
            return head;
        }
        ListNode guard = new ListNode();
        guard.next = head;

        ListNode p = head;

        while (p.next != tail) {
            if (p.next.val <= head.val) {
                ListNode temp = p.next;
                p.next = p.next.next;
                temp.next = guard.next;
                guard.next = temp;
            } else {
                p = p.next;
            }
        }

        head.next = sort(head.next, tail);
        return sort(guard.next, head);
    }

    public static void main(String[] args) {
        print(new Solution().sortList(gen(new int[]{4, 2, 1, 3})));
    }

    public static ListNode gen(int[] arr) {
        ListNode head = new ListNode();
        ListNode p = head;
        for (int n : arr) {
            p.next = new ListNode(n);
            p = p.next;
        }
        return head.next;
    }

    public static void print(ListNode head) {
        System.out.print("[");
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val);
            System.out.print(",");
            p = p.next;
        }
        System.out.println("]");
    }
}
