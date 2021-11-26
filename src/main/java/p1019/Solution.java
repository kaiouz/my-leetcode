package p1019;

import java.util.LinkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {

    public int[] nextLargerNodes(ListNode head) {
        int size = 0;
        ListNode reverse = null;
        ListNode p = head;

        while (p != null) {
            ListNode temp = p;
            p = p.next;

            temp.next = reverse;
            reverse = temp;

            size++;
        }

        LinkedList<Integer> stack = new LinkedList<>();
        int[] ans = new int[size];

        p = reverse;
        for (int i = ans.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && p.val >= stack.peek()) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(p.val);
            p = p.next;
        }

        return ans;
    }

}
