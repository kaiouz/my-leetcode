package p1346;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkIfExist(int[] arr) {
        Map<Integer, Boolean> cache = new HashMap<>();
        for (int n : arr) {
            if (cache.containsKey(n*n)) {
                return true;
            } else if (n % 2 == 0 && cache.containsKey(n / 2)) {
                return true;
            }
            cache.put(n, true);
        }
        return false;
    }
}
