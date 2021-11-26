package p234;

import java.util.LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {

    public boolean isPalindrome(ListNode head) {
        LinkedList<ListNode> stack = new LinkedList<>();
        for (ListNode p = head; p != null; p = p.next) {
            stack.addFirst(p);
        }

        ListNode p = head;
        for (ListNode s : stack) {
            if (s.val != p.val) {
                return false;
            }
            p = p.next;
        }

        return true;
    }


}
