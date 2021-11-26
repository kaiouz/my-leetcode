package p49;

import java.util.*;

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> cache = new HashMap<>();

        for (String str : strs) {
            char[] chars = new char[str.length()];
            str.getChars(0, str.length(), chars, 0);
            Arrays.sort(chars);
            List<String> list = cache.computeIfAbsent(new String(chars), (k) -> new ArrayList<>());
            list.add(str);
        }

        return new ArrayList<>(cache.values());
    }


}
