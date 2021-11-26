package offer06;

import java.util.LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {

    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }
        int[] ans = new int[stack.size()];
        int idx = 0;
        for (int n : stack) {
            ans[idx++] = n;
        }
        return ans;
    }

}
