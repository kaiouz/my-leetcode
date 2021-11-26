package ms0202;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {

    public int kthToLast(ListNode head, int k) {
        int d = 0;

        ListNode p = head;
        ListNode ans = head;

        while (p != null) {
            p = p.next;
            if (d < k) {
                d++;
            } else {
                ans = ans.next;
            }
        }

        return ans.val;
    }


}
