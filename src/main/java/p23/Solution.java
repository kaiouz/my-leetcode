package p23;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode p = head;

        while (true) {
            int curIndex = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (curIndex < 0) {
                        curIndex = i;
                    } else {
                        curIndex = lists[i].val < lists[curIndex].val ? i : curIndex;
                    }
                }
            }
            if (curIndex < 0) {
                break;
            } else {
                p.next = lists[curIndex];
                p = p.next;
                lists[curIndex] = lists[curIndex].next;
            }
        }

        return head.next;
    }

}
