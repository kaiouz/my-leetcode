package ms1711;

class Solution {

    public int findClosest(String[] words, String word1, String word2) {
        int i1 = -1;
        int i2 = -1;

        int min = words.length;

        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                i1 = i;
                if (i2 != -1) {
                    min = Math.min(min, i1 - i2);
                }
            } else if (word2.equals(words[i])) {
                i2 = i;
                if (i1 != -1) {
                    min = Math.min(min, i2 - i1);
                }
            }
        }

        return min;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().findClosest(
                new String[]{"I", "am", "a", "student", "from", "a", "university", "in", "a", "city"},
                "a", "student"));
    }

}
