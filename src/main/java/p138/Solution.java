package p138;

import java.util.HashMap;
import java.util.Map;

// Definition for a Node.
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
        Node copyHead = new Node(0);
        Node copyTail = copyHead;

        Map<Node, Node> copyMap = new HashMap<>();

        Node p = head;
        while (p != null) {
            Node node = new Node(p.val);
            copyTail.next = node;
            copyTail = copyTail.next;
            copyMap.put(p, node);
            p = p.next;
        }

        Node copyP = copyHead.next;
        p = head;

        while (p != null) {
            copyP.random = copyMap.get(p.random);
            p = p.next;
            copyP = copyP.next;
        }

        return copyHead.next;
    }
}
