package p567;

class Solution {

    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        int[] count = new int[26];

        int req = 0;
        for (int i = 0; i < l1; i++) {
            count[s1.charAt(i) - 'a']--;
            req++;
        }

        for (int l = -l1, r = 0; r < l2; l++, r++) {
            int idx = s2.charAt(r) - 'a';
            if (++count[idx] <= 0) {
                req--;
            } else {
                req++;
            }

            if (l >= 0) {
                idx = s2.charAt(l) - 'a';
                if (--count[idx] >= 0) {
                    req--;
                } else {
                    req++;
                }
            }

            if (req == 0 && l >= -1) {
                return true;
            }
        }

        return false;
    }

}
