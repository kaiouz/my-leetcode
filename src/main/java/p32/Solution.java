package p32;

import java.util.LinkedList;
import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestValidParentheses("()"));
    }
}
