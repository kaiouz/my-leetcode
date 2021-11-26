package p143;

import java.util.LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public void reorderList(ListNode head) {
        LinkedList<ListNode> list = new LinkedList<>();
        ListNode p = head;
        while (p != null) {
            list.addLast(p);
            p = p.next;
        }

        while (!list.isEmpty()) {
           ListNode p1 = list.pollFirst();
           ListNode p2 = list.pollLast();
           if (p2 != null) {
               p2.next = list.peekFirst();
           }
           p1.next = p2;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        new Solution().reorderList(n1);
    }
}
