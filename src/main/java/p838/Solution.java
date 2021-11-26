package p838;

import java.util.Arrays;

class Solution {

    public String pushDominoes(String dominoes) {
        char[] ans = new char[dominoes.length()];

        char prev = 0;
        int prevIndex = -1;

        for (int i = 0; i < dominoes.length(); i++) {
            char cur = dominoes.charAt(i);
            if (cur == 'L') {
                if (prevIndex >= 0) {
                    if (prev == 'R') {
                        fillLR(ans, prevIndex, i);
                    } else {
                        Arrays.fill(ans, prevIndex + 1, i + 1, 'L');
                    }
                } else {
                    Arrays.fill(ans, 0, i + 1, 'L');
                }
                prev = 'L';
                prevIndex = i;
            } else if (cur == 'R') {
                if (prevIndex >= 0) {
                    if (prev == 'L') {
                        Arrays.fill(ans, prevIndex + 1, i, '.');
                        ans[i] = 'R';
                    } else {
                        Arrays.fill(ans, prevIndex + 1, i + 1, 'R');
                    }
                } else {
                    Arrays.fill(ans, 0, i, '.');
                    ans[i] = 'R';
                }
                prev = 'R';
                prevIndex = i;
            }
        }

        if (prev == 'R') {
            Arrays.fill(ans, prevIndex + 1, ans.length, 'R');
        } else {
            Arrays.fill(ans, prevIndex + 1, ans.length, '.');
        }

        return new String(ans);
    }

    private void fillLR(char[] ans, int left, int right) {
        while (left < right) {
            ans[left++] = 'R';
            ans[right--] = 'L';
        }
        if (left == right) {
            ans[left] = '.';
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().pushDominoes("RR.L"));
    }
}
