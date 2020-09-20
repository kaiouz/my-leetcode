package p5472;

class Solution {
    public String restoreString(String s, int[] indices) {
        char[] r = new char[s.length()];

        for (int i = 0; i < s.length(); ++i) {
            r[indices[i]] = s.charAt(i);
        }

        return new String(r);
    }
}
