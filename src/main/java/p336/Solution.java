package p336;

import java.util.*;

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            String wr = reverse(words[i]);
            Integer exists = map.get(wr);
            if (exists != null) {
                result.add(Arrays.asList(exists, i));
                result.add(Arrays.asList(i, exists));
            }
            map.put(words[i], i);
        }

        return result;
    }

    private String reverse(String s) {
        char[] chars = new char[s.length()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = s.charAt(chars.length - i - 1);
        }
        return new String(chars);
    }
}
