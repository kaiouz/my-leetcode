package p1540;

class Solution {

    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) {
            return false;
        }
        int a = k / 26;
        int b = k % 26;
        int[] times = new int[26];
        for (int i = 1; i < times.length; i++) {
            if (i <= b) {
                times[i] = a + 1;
            } else {
                times[i] = a;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            int diff = (ct - cs + 26) % 26;
            if (diff != 0 && --times[diff] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canConvertString("input",
                "ouput",
                9));
    }
}
