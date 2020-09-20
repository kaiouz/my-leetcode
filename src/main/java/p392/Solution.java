package p392;

class Solution {
    public boolean isSubsequence(String s, String t) {
        int si = 0, ti = 0;

        int sl = s.length();
        int tl = t.length();
        while (si < sl && ti < tl) {
            if (s.charAt(si) == t.charAt(ti)) {
                si++;
            }
            ti++;
        }

        return si >= sl;
    }
}
