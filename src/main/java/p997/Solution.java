package p997;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;

class Solution {
    public int[] sortedSquares(int[] A) {
        return Arrays.stream(A).map(it -> it * it).sorted().toArray();
    }
}
