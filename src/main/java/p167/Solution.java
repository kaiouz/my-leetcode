package p167;

import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) {
            int r = Arrays.binarySearch(numbers, i + 1, numbers.length, target - numbers[i]);
            if (r > 0) {
                return new int[]{i+1, r+1};
            }
        }
        return null;
    }
}
