package p1249;

class Solution {
    public String minRemoveToMakeValid(String s) {
        int left = 0;

        StringBuilder sb = new StringBuilder(s.length());

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left <= 0) {
                    continue;
                }
                left--;
            }
            sb.append(c);
        }

        if (left == 0) {
            return sb.toString();
        }

        StringBuilder ans = new StringBuilder(sb.length());
        int right = 0;
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (c == ')') {
                right++;
            } else if (c == '(') {
                if (right <= 0) {
                    continue;
                }
                right--;
            }
            ans.append(c);
        }

        return ans.reverse().toString();
    }
}
