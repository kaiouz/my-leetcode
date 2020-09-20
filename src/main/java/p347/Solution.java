package p347;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int n : nums) {
            cache.compute(n, (__, v) -> v == null ? 1 : v + 1);
        }
        return cache.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .limit(k)
                .collect(() -> new int[k], new BiConsumer<int[], Map.Entry<Integer, Integer>>() {
                    private int i = 0;

                    @Override
                    public void accept(int[] r, Map.Entry<Integer, Integer> integerIntegerEntry) {
                        r[i++] = integerIntegerEntry.getKey();
                    }
                }, new BiConsumer<int[], int[]>() {
                    @Override
                    public void accept(int[] ints, int[] ints2) {

                    }
                });
    }
}
