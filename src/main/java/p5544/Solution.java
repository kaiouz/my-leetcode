package p5544;

import java.util.Arrays;

class Solution {

    public String findLexSmallestString(String s, int a, int b) {

        int minIdx = 0;
        int minV = Integer.MAX_VALUE;
        int minC = 0;

        final int len = s.length();
        for (int i = 0; i < len; i += b) {
            int n = s.charAt(i) - '0';
            if (i % 2 == 1) {
                int[] minArr = findMin(n, a);
                if (minArr[0] < minV) {
                    minV = minArr[0];
                    minIdx = i;
                    minC = minArr[1];
                }
            } else {
                if (n < minV) {
                    minV = n;
                    minIdx = i;
                    minC = 1;
                }
            }
        }

        char[] ans = new char[len];

        int fan = minC * a;
        for (int i = 0; i < ans.length; i++) {
            int idx = (minIdx + i) % len;
            if (idx % 2 == 1) {
                int[] mix = findMin(s.charAt(idx) - '0', fan);
                ans[i] = (char) (mix[0] + '0');
                fan *= mix[1];
            } else {
                ans[i] = s.charAt(idx);
            }
        }

        return new String(ans);
    }


    private static int[] findMin(int x, int y) {
        int min = x;
        int i = 1;
        int cur = 0;
        while ((cur = (x + i * y) % 10) != x) {
            min = Math.min(min, cur);
            i++;
        }
        if (min == x) {
            return new int[]{min, 0};
        }
        return new int[]{min, i - 1};
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findLexSmallestString("74", 5, 1));
//        System.out.println(Arrays.toString(findMin(7, 8)));
    }
}
