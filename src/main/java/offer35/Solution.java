package offer35;


import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


class Solution {

    public Node copyRandomList(Node head) {
        Map<Node, Node> cache = new HashMap<>();

        Node p = head;
        Node cloneHead = new Node(0);
        Node cloneP = cloneHead;

        while (p != null) {
            Node c = new Node(p.val);
            cache.put(p, c);
            cloneP.next = c;
            p = p.next;
            cloneP = cloneP.next;
        }

        p = head;
        cloneHead = cloneHead.next;
        cloneP = cloneHead;

        while (p != null) {
            if (p.random != null) {
                cloneP.random = cache.get(p.random);
            }
            p = p.next;
            cloneP = cloneP.next;
        }

        return cloneHead;
    }


}
