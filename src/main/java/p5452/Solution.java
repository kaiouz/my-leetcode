package p5452;

import java.util.Arrays;

class Solution {

    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length <= 1) {
            return true;
        }
        Arrays.sort(arr);

        int c = arr[1] - arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i-1] != c) {
                return false;
            }
        }
        return true;
    }

}
