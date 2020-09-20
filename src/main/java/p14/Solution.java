package p14;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0) {
            return "";
        }
        String common = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (common.isEmpty()) {
                return "";
            }
            common = commonPrefix(common, strs[i]);
        }
        return common;
    }

    private String commonPrefix(String a, String b) {
        int count = Math.min(a.length(), b.length());
        int i = 0;
        for (; i < count && a.charAt(i) == b.charAt(i); i++) ;
        return a.substring(0, i);
    }

    public static void main(String[] args) {
       String a = new Solution().longestCommonPrefix(new String[]{"dog","racecar","car"});
        System.out.println(a);
    }
}
