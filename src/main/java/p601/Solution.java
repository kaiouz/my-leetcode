package p601;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int d = 0;
        ListNode mid = head;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            if (d < k) {
                d++;
            } else {
                mid = mid.next;
            }
        }

        if (d < k) {
            k %= d + 1;
            if (k == 0) {
                return head;
            } else {
                int n = d - k;
                while (n-- > 0) {
                    mid = mid.next;
                }
            }
        }

        tail.next = head;
        head = mid.next;
        mid.next = null;

        return head;
    }


}
