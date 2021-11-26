package p115;

import java.util.*;

class Solution {

    public int numDistinct(String s, String t) {
        int[] dp = new int[t.length() + 1];
        dp[0] = 1;

        Map<Character, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.computeIfAbsent(t.charAt(i), (k) -> new LinkedList<>()).addFirst(i);
        }

        LinkedList<Integer> empty = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            for (int idx : map.getOrDefault(s.charAt(i), empty)) {
                dp[idx + 1] += dp[idx];
            }
        }

        return dp[dp.length - 1];
    }


    public static void main(String[] args) {
        System.out.println(new Solution().numDistinct("rabbbit", "rabbit"));
    }
}
