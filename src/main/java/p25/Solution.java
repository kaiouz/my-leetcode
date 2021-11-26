package p25;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;

        ListNode p1 = tempHead, p2 = tempHead;
        int step = 0;

        while (p2.next != null) {
            p2 = p2.next;
            step++;
            if (step % k == 0) {
                ListNode reverseHead = p2.next;
                ListNode reverseTailNext = p2.next;
                ListNode reverseTail = p1.next;
                ListNode p = p1.next;
                while (p != reverseTailNext) {
                    ListNode temp = p;
                    p = p.next;
                    temp.next = reverseHead;
                    reverseHead = temp;
                }
                p1.next = reverseHead;
                p1 = reverseTail;
                p2 = p1;
            }
        }

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

        System.out.println(new Solution().reverseKGroup(n1, 2));
    }

}
