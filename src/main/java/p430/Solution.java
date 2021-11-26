package p430;

// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};


class Solution {

//    public Node flatten(Node head) {
//        helper(head);
//        return head;
//    }
//
//    private Node helper(Node head) {
//        Node tail = null;
//
//        Node p = head;
//
//        while (p != null) {
//
//            if (p.child != null) {
//                Node childT = helper(p.child);
//                if (p.next != null) {
//                    Node next = p.next;
//                    childT.next = next;
//                    next.prev = childT;
//                }
//
//                p.child.prev = p;
//                p.next = p.child;
//                p.child = null;
//
//                p = childT;
//            }
//
//            if (p.next == null) {
//                tail = p;
//            }
//            p = p.next;
//        }
//
//        return tail;
//    }

    private Node p = new Node();

    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    private void dfs(Node node) {
        if (node == null) {
            return;
        }

        Node next = node.next;

        p.next = node;
        node.prev = p;
        p = node;

        if (node.child != null) {
            dfs(node.child);
            node.child = null;
        }

        dfs(next);
    }


    public static void main(String[] args) {
        Node n1 = new Node();
        n1.val = 1;

        Node n2 = new Node();
        n2.val = 2;
        n1.next = n2;
        n2.prev = n1;

        Node n3 = new Node();
        n3.val = 3;
        n2.next = n3;
        n3.prev = n2;

        Node n4 = new Node();
        n4.val = 4;
        n3.next = n4;
        n4.prev = n3;

        Node n5 = new Node();
        n5.val = 5;
        n4.next = n5;
        n5.prev = n4;

        Node n6 = new Node();
        n6.val = 6;
        n5.next = n6;
        n6.prev = n5;

        Node n7 = new Node();
        n7.val = 7;
        n3.child = n7;

        Node n8 = new Node();
        n8.val = 8;
        n7.next = n8;
        n8.prev = n7;

        Node n9 = new Node();
        n9.val = 9;
        n8.next = n9;
        n9.prev = n8;

        Node n10 = new Node();
        n10.val = 10;
        n9.next = n10;
        n10.prev = n9;

        Node n11 = new Node();
        n11.val = 11;
        n8.child = n11;

        Node n12 = new Node();
        n12.val = 12;
        n11.next = n12;
        n12.prev = n11;

        System.out.println(new Solution().flatten(n1));
    }
}
