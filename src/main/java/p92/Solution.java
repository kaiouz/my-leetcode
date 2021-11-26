package p92;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;

        int distance = n - m + 1;
        int step = 0;

        ListNode pn = tempHead;
        ListNode pm = tempHead;

        while (step++ < n) {
            pn = pn.next;
            if (step > distance) {
                pm = pm.next;
            }
        }

        ListNode reverseHead = pn.next;
        ListNode reverseTail = pn.next;
        ListNode p = pm.next;
        while (p != reverseTail) {
            ListNode temp = p;
            p = p.next;
            temp.next = reverseHead;
            reverseHead = temp;
        }
        pm.next = reverseHead;

        return tempHead.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        Solution2.print(new Solution().reverseBetween(n1, 2, 4));
    }
}
