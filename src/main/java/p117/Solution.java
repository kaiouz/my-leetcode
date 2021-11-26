package p117;

import java.util.Collections;
import java.util.LinkedList;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

class Solution {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        LinkedList<Node> stack = new LinkedList<>();
        stack.push(root);
        int size = 0;
        while ((size = stack.size()) > 0) {
            Node prev = null;
            for (int i = 0; i < size; i++) {
                Node node = stack.removeFirst();
                if (prev != null) {
                    prev.next = node;
                }
                prev = node;
                if (node.left != null)
                    stack.addLast(node.left);
                if (node.right != null) {
                    stack.addLast(node.right);
                }
            }
        }
        return root;
    }

}
