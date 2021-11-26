package offer36;


import java.util.LinkedList;

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

class Solution {

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node head = new Node();
        Node tail = head;

        LinkedList<Node> stack = new LinkedList<>();
        Node node = root;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.poll();
            tail.right = node;
            node.left = tail;
            tail = tail.right;
            node = node.right;
        }

        tail.right = head.right;
        head.right.left = tail;

        return head.right;
    }

}
