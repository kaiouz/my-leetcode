package p973;

import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparingInt(it -> it[0]*it[0] + it[1]*it[1]));
        return Arrays.copyOfRange(points, 0, K);
    }


}
