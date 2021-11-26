package p1047;

class Solution {

    public String removeDuplicates(String S) {
        if (S.length() < 2) {
            return S;
        }

        StringBuilder sb = new StringBuilder(S.length());
        sb.append(S.charAt(0));
        int last = 0;

        for (int r = 1; r < S.length(); r++) {
            char c = S.charAt(r);
            if (last >= 0 && c == sb.charAt(last)) {
                sb.deleteCharAt(last);
                last--;
            } else {
                sb.append(c);
                last++;
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates("abbaca"));
    }
}
