package p17;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution {

    private List<String> list = new LinkedList<>();

    private char[][] map = new char[][]{
            new char[]{},
            new char[]{},
            new char[]{'a', 'b', 'c'},
            new char[]{'d', 'e', 'f'},
            new char[]{'g', 'h', 'i'},
            new char[]{'j', 'k', 'l'},
            new char[]{'m', 'n', 'o'},
            new char[]{'p', 'q', 'r', 's'},
            new char[]{'t', 'u', 'v'},
            new char[]{'w', 'x', 'y', 'z'},
    };

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return Collections.emptyList();
        }
        helper(digits, new char[digits.length()], 0);
        return list;
    }

    private void helper(String digits, char[] sb, int index) {
        if (index >= digits.length()) {
            list.add(new String(sb));
            return;
        }
        char[] chars = map[digits.charAt(index) - '0'];
        for (char aChar : chars) {
            sb[index] = aChar;
            helper(digits, sb, index + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
    }
}
