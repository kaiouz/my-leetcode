package p116;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}


class Solution {
    public Node connect(Node root) {
        Node n = new Node();

        Node head = root;
        Node tail = n;
        head.next = tail;

        while (head != null) {
            if (head.left != null) {
                tail.next = head.left;
                tail = tail.next;
            }
            if (head.right != null) {
                tail.next = head.right;
                tail = tail.right;
            }
            if (head.next == n) {
                Node p = head;
                head = head.next.next;
                p.next = null;
                n.next = null;
                tail.next = n;
                tail = tail.next;
            } else  {
                head = head.next;
            }
        }
        return root;
    }
}
