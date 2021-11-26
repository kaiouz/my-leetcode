package test;

class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int p = 0;

        while (p < sentence.length()) {
            int sp = 0;
            int ans = p;
            while (p < sentence.length()
            && sp <searchWord.length()
            && searchWord.charAt(sp) == sentence.charAt(p)) {
                sp++;
                p++;
            }
            if (sp == searchWord.length()) {
                return ans;
            }
            while(p < sentence.length() && sentence.charAt(p) != ' ') {
                p++;
            }
            p++;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPrefixOfWord("i love eating burger", "burg"));
    }
}
