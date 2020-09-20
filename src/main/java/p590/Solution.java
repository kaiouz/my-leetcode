package p590;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {

    public List<Integer> postorder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> result = new LinkedList<>();

        if (root.children != null) {
            for (Node n : root.children) {
                result.addAll(postorder(n));
            }
        }

        result.add(root.val);

        return result;
    }


}
