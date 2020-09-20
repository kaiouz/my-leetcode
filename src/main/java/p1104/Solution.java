package p1104;

import java.util.LinkedList;
import java.util.List;

class Solution {


    public List<Integer> pathInZigZagTree(int label) {
        LinkedList<Integer> result = new LinkedList<>();
        int line = lines(label);
        while (line-- > 0) {
            result.addFirst(label);
            label /= 2;
            label = 3 * pow2(line - 1) - label - 1;
        }
        return result;
    }

    private int pow2(int p) {
        return 1 << p;
    }

    private int lines(int num) {
        int p = 0;
        while (num > 0) {
            p++;
            num = num >>> 1;
        }
        return p;
    }

    public static void main(String[] args) {
        new Solution().pathInZigZagTree(26);
    }
}
