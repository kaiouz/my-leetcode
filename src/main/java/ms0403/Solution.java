package ms0403;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {

    public ListNode[] listOfDepth(TreeNode tree) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);

        int size = 0;

        List<ListNode> res = new ArrayList<>();

        ListNode head = new ListNode(0);
        ListNode cur = null;

        while ((size = queue.size()) > 0) {
            cur = head;

            for (int i = 0; i < size; i++) {
                TreeNode tn = queue.poll();
                cur.next = new ListNode(tn.val);
                cur = cur.next;

                if (tn.left != null) {
                    queue.offer(tn.left);
                }
                if (tn.right != null) {
                    queue.offer(tn.right);
                }
            }

            res.add(head.next);
        }

        return res.toArray(new ListNode[0]);
    }
}
