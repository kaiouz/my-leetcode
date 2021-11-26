package p1481;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int n : arr) {
            counts.compute(n, (kk, v) -> v == null ? 1 : v + 1);
        }
        int ans = counts.size();

        List<Map.Entry<Integer, Integer>> entryList = counts.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getValue))
                .collect(Collectors.toList());

        for (Map.Entry<Integer, Integer> entry : entryList) {
            if (entry.getValue() <= k) {
                ans--;
                k -= entry.getValue();
            } else {
                break;
            }
        }

        return ans;
    }
}
