package p1122;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }

        return Arrays.stream(arr1).boxed()
                .sorted((a, b) -> {
                    int ai = map.getOrDefault(a, arr2.length);
                    int bi = map.getOrDefault(b, arr2.length);
                    if (ai == bi) {
                        return a - b;
                    }
                    return ai - bi;
                })
                .mapToInt(a -> a)
                .toArray();
    }


}
