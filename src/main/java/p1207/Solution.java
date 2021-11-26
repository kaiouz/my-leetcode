package p1207;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : arr) {
            freq.compute(n, (k ,v) -> v == null ? 1 : v + 1);
        }

        return freq.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toSet()).size() == freq.size();
    }


}
