package p68;

import java.util.LinkedList;
import java.util.List;

class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new LinkedList<>();

        int len = 0;
        int start = 0;
        for (int i = 0; i < words.length; i++) {
            int curLen = len + words[i].length() + (len == 0 ? 0 : 1);
            if (curLen > maxWidth) {
                ans.add(convert(words, start, i, maxWidth, len));
                len = words[i].length();
                start = i;
            } else {
                len = curLen;
            }
        }

        ans.add(convert(words, start, words.length, maxWidth));

        return ans;
    }

    private String convert(String[] words, int start, int end, int maxWidth, int len) {
        char[] chars = new char[maxWidth];
        int i = 0;

        int count = end - start - 1;
        int total = maxWidth - len + count;
        int spaces = count == 0 ? 0 : total / count;
        int change = count == 0 ? start : start + total % count;

        for (int j = start; j < change; j++) {
            i = append(chars, i, words[j], spaces + 1);
        }
        for (int j = change; j < end-1; j++) {
            i = append(chars, i, words[j], spaces);
        }
        i = append(chars, i, words[end-1], 0);
        for (; i < maxWidth; i++) {
            chars[i] = ' ';
        }
        return new String(chars);
    }

    private String convert(String[] words, int start, int end, int maxWidth) {
        char[] chars = new char[maxWidth];
        int i = 0;
        for (int j = start; j < end; j++) {
            for (int k = 0; k < words[j].length(); k++) {
                chars[i++] = words[j].charAt(k);
            }
            if (j < end - 1) {
                chars[i++] = ' ';
            }
        }
        for (; i < maxWidth; i++) {
            chars[i] = ' ';
        }
        return new String(chars);
    }

    private int append(char[] chars, int i, String word, int spaces) {
        for (int j = 0; j < word.length(); j++) {
            chars[i++] = word.charAt(j);
        }
        for (int j = 0; j < spaces; j++) {
            chars[i++] = ' ';
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"},
                16));
    }
}
