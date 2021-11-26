package p953;

class Solution {

    public boolean isAlienSorted(String[] words, String order) {
        int[] orders = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orders[order.charAt(i) - 'a'] = i;
        }

        String pre = words[0];

        for (int i = 1; i < words.length; i++) {
            if (!small(pre, words[i], orders)) {
                return false;
            }
            pre = words[i];
        }

        return true;
    }

    private boolean small(String a, String b, int[] order) {
        int len = Math.min(a.length(), b.length());
        for (int i = 0; i < len; i++) {
            int aa = order[a.charAt(i)-'a'];
            int bb = order[b.charAt(i)-'a'];
            if (aa < bb) {
                return true;
            } else if (aa > bb) {
                return false;
            }
        }
        return a.length() <= b.length();
    }


    public static void main(String[] args) {
        System.out.println(new Solution().isAlienSorted(new String[] {"hello","leetcode"},
        "hlabcdefgijkmnopqrstuvwxyz"));
    }
}
