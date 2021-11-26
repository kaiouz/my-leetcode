package p5537;

class Solution {

    public boolean checkPalindromeFormation(String a, String b) {
        return helper(a, 0, b, b.length() - 1) || helper(b, 0, a, a.length() - 1);
    }

    private boolean helper(String a, int ai, String b, int bi) {
        if (ai >= bi) {
            return true;
        }

        if (a.charAt(ai) == b.charAt(bi)) {
            return helper(a, ai + 1, b, bi - 1);
        } else if (a != b) {
            return helper(a, ai, a, bi) || helper(b, ai, b, bi);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkPalindromeFormation("ulacfd", "jizalu"));
    }
}
