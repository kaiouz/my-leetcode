package p1370;

class Solution {

    public String sortString(String s) {
        char[] ans = new char[s.length()];
        int idx = 0;

        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        while (idx < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (num[i] > 0) {
                    ans[idx++] = (char) (i + 'a');
                    num[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (num[i] > 0) {
                    ans[idx++] = (char) (i + 'a');
                    num[i]--;
                }
            }
        }

        return new String(ans);
    }


}
