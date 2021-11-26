package p429;

import p297.TreeNode;

import java.util.ArrayList;
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

    public List<List<Integer>> levelOrder(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();

        if (root != null) {
            queue.addLast(root);
        }

        int size = 0;
        while ((size = queue.size()) > 0) {
            List<Integer> list = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                Node node = queue.pollFirst();
                list.add(node.val);
                for (Node child : node.children) {
                    queue.addLast(child);
                }
            }

            ans.add(list);
        }

        return ans;
    }


}
