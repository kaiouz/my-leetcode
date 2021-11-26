package p151;

class Solution {

    public String reverseWords(String s) {
        char[] ans = new char[s.length() + 1];
        int t = 0;

        int i = s.length() - 1;
        int r;

        while (i >= 0) {
            while (i >=0 && s.charAt(i) == ' ') {
                i--;
            }
            r = i;
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            if (i < r) {
                ans[t++] = ' ';
                for (int j = i + 1; j <= r; j++) {
                    ans[t++] = s.charAt(j);
                }
            }
        }


        return new String(ans, 1, t-1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("the sky is blue"));
    }
}
