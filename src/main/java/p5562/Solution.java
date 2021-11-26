package p5562;

import java.util.Arrays;

class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        Arrays.sort(freq);

        int ans = 0;
        for (int i = freq.length - 2; i >= 0; i--) {
            while (freq[i] > 0 && freq[i] >= freq[i + 1]) {
                freq[i]--;
                ans++;
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minDeletions("bbcebab"));
    }
}
