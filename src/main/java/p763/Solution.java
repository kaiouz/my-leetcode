package p763;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList<>();
        int[] counts = new int[26];
        int[] freq = new int[26];
        int loss = 0;

        for (int i = 0; i < S.length(); i++) {
            counts[S.charAt(i) - 'a']++;
        }

        int left = -1;
        for (int right = 0; right < S.length(); right++) {
            final int c = S.charAt(right) - 'a';
            freq[c]++;
            if (freq[c] == 1) {
                if (counts[c] - freq[c] > 0) {
                    loss++;
                }
            } else {
                if (counts[c] - freq[c] == 0) {
                    loss--;
                }
            }

            if (loss == 0) {
                ans.add(right - left);
                while (left < right) {
                    freq[S.charAt(++left) - 'a']--;
                }
            }
        }

        return ans;
    }
}
