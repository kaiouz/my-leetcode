package p5543;

import java.util.Arrays;

class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] position = new int[26];
        Arrays.fill(position, -1);
        int ans = -1;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (position[idx] >= 0) {
                ans = Math.max(ans, i - position[idx] - 1);
            } else {
                position[idx] = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxLengthBetweenEqualCharacters("abca"));
    }
}
