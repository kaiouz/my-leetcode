package p5519;

import java.util.Arrays;

class Solution {
    public String reorderSpaces(String text) {
        String[] strs = text.split("\\s+");
        if (strs[0].length() == 0) {
            strs = Arrays.copyOfRange(strs, 1, strs.length);
        }
        int sum = Arrays.stream(strs).mapToInt(String::length).sum();
        int spaceCount = text.length() - sum;
        int spaceAv = 0;
        int tail = spaceCount;
        if (strs.length > 1) {
            spaceAv = spaceCount / (strs.length - 1);
            tail = spaceCount % (strs.length-1);
        }
        return String.join(space(spaceAv), strs) + space(tail);
    }

    private String space(int n) {
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("\"" + new Solution().reorderSpaces("a")+"\"");
    }
}
