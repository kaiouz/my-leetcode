package ms1611;

class Solution {

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        int[] r = new int[k + 1];
        r[0] = shorter * k;
        int c = longer - shorter;
        for (int i = 1; i < r.length; i++) {
            r[i] = r[i - 1] + c;
        }
        return r;
    }

}
