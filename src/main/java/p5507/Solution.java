package p5507;

class Solution {

    public String modifyString(String s) {
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '?') {
                char left = i > 0 ? str[i - 1] : 0;
                char right = i < str.length - 1 ? str[i + 1] : 0;
                str[i] = helper(left, right);
            }
        }
        return new String(str);
    }

    private char helper(char l, char r) {
        for (char c = 'a'; c <= 'z'; c++) {
            if (c != l && r != c) {
                return c;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().modifyString("??yw?ipkj?"));
    }
}
