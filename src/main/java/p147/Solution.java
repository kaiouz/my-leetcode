package p147;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {

    public ListNode insertionSortList(ListNode head) {
       ListNode sorted = new ListNode(0);

       ListNode temp = null;
       ListNode p = head;
       while (p != null) {
           temp = p;
           p = p.next;

           ListNode insert = sorted;
           while (insert.next != null) {
               if (temp.val < insert.next.val) {
                   break;
               }
               insert = insert.next;
           }
           temp.next = insert.next;
           insert.next = temp;
       }

       return sorted.next;
    }


}
