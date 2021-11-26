package p817;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int g : G) {
            set.add(g);
        }

        int count = 0;
        boolean prev = false;
        ListNode p = head;
        while (p != null) {
            if (set.contains(p.val)) {
                if (!prev) {
                    count++;
                    prev = true;
                }
            } else {
                prev = false;
            }
            p = p.next;
        }
        return count;
    }
}
