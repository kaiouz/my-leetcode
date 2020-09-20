package p894;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    private Map<Integer, List<TreeNode>> caches = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int N) {
        if (caches.containsKey(N)) {
            return caches.get(N);
        }

        List<TreeNode> list = new LinkedList<>();

        if (N == 1) {
            list.add(new TreeNode(0));
        }

        for (int i = 1; i < N; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N-1-i);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode node = new TreeNode(0);
                    node.left = l;
                    node.right = r;
                    list.add(node);
                }
            }
        }

        caches.put(N, list);

        return list;
    }


}
