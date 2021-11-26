package p5535;

import java.util.LinkedList;

class Solution {

    public int maxDepth(String s) {
        int stack = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack++;
                max = Math.max(max, stack);
            } else if (c == ')') {
                stack--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxDepth("1"));
    }

}
