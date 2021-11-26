package p1107;

import java.util.LinkedList;
import java.util.List;

class Solution {

    public List<Integer> pathInZigZagTree(int label) {
        int n = 1 << log2(label);
        int x = label;
        LinkedList<Integer> ans = new LinkedList<>();
        while (x != 0) {
            ans.addFirst(x);
            x = (3 * n - 1 - x) / 2;
            n = n >>> 1;
        }
        return ans;
    }

    private int log2(int val) {
        int count = -1;
        while (val != 0) {
            val = val >>> 1;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().pathInZigZagTree(14));
    }
}
