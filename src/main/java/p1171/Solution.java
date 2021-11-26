package p1171;

import java.util.HashMap;
import java.util.Map;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode sumHead = new ListNode(0);
        ListNode sumTail = sumHead;

        ListNode nodeHead = new ListNode(0);
        nodeHead.next = head;

        Map<Integer, Pair> cache = new HashMap<>();
        cache.put(0, new Pair(nodeHead, sumHead));

        Map<ListNode, Integer> sumCache = new HashMap<>();
        sumCache.put(sumHead, 0);

        ListNode p = nodeHead.next;

        while (p != null) {
            int pSum = p.val + sumTail.val;
            Pair pair = cache.get(pSum);

            if (pair != null) {
                pair.node.next = p.next;
                sumTail = pair.sumNode;
                ListNode sumP = sumTail.next;
                while (sumP != null) {
                    cache.remove(sumCache.remove(sumP));
                    sumP = sumP.next;
                }
                sumTail.next = null;
            } else {
                ListNode pSumNode = new ListNode(pSum);
                sumTail.next = pSumNode;
                sumTail = sumTail.next;
                cache.put(pSum, new Pair(p, pSumNode));
                sumCache.put(pSumNode, pSum);
            }

            p = p.next;
        }

        return nodeHead.next;
    }

    static class Pair {
        ListNode node;
        ListNode sumNode;
        public Pair(ListNode node, ListNode sumNode) {
            this.node = node;
            this.sumNode = sumNode;
        }
    }

}
