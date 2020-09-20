package p133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution {

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        return clone(node, new HashMap<>());
    }

    private Node clone(Node node, Map<Integer, Node> cache) {
        Node copy = cache.get(node.val);
        if (copy == null) {
            copy = new Node(node.val);
            cache.put(node.val, copy);

            for (Node neighbor : node.neighbors) {
                copy.neighbors.add(clone(neighbor, cache));
            }
        }
        return copy;
    }

}
