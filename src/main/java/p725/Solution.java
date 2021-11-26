package p725;

import java.util.Arrays;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];

        int n = 0;
        ListNode p = head;
        while (p != null) {
            n++;
            p = p.next;
        }

        int beforeAvg = (n + k - 1) / k;
        int afterAvg = beforeAvg - 1;
        int index = n % k == 0 ? n : n % k;

        ListNode p1 = head, p2 = head;
        int m = Math.min(n, k);
        for (int i = 0; i < m; i++) {
            int len = i < index ? beforeAvg : afterAvg;
            for (int j = 1; j < len; j++) {
                p2 = p2.next;
            }
            ans[i] = p1;
            p1 = p2.next;
            p2.next = null;
            p2 = p1;
        }

        return ans;
    }


    public static void main(String[] args) {
        ListNode p0 = new ListNode(0);
        ListNode p1 = new ListNode(1);
        p0.next = p1;

        System.out.println(Arrays.toString(new Solution().splitListToParts(p0, 1)));
    }
}
