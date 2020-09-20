package p20;

import java.util.LinkedList;

class Solution {

    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                Character last = stack.poll();
                if (last == null) {
                    return false;
                } else {
                    if (!((c == ')' && last == '(')
                            || (c == '}' && last == '{')
                            || (c == ']' && last == '['))) {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }


    public static void main(String[] args) {
        new Solution();
    }
}
