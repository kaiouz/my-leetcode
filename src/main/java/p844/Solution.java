package p844;

import java.util.Objects;

class Solution {

    public boolean backspaceCompare(String S, String T) {
        return Objects.equals(common(S), common(T));
    }

    private String common(String S) {
        StringBuilder sSb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '#') {
                if (sSb.length() > 0) {
                    sSb.deleteCharAt(sSb.length() - 1);
                }
            } else {
                sSb.append(c);
            }
        }
        return sSb.toString();
    }


    public static void main(String[] args) {
        System.out.println(new Solution().backspaceCompare("ab#c",
                "ad#c"));
    }
}
