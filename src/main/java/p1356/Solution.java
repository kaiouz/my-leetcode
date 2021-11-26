package p1356;

import java.util.Arrays;

class Solution {

    public int[] sortByBits(int[] arr) {
       return Arrays.stream(arr).boxed()
                .sorted(this::compare)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    int compare(int a, int b) {
        int diff = Integer.bitCount(a) - Integer.bitCount(b);
        return diff != 0 ? diff : Integer.compare(a, b);
    }

}
