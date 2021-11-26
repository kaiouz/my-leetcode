package p240;

import java.util.Arrays;

class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] arr : matrix) {
            if (target >= arr[0] && target <= arr[arr.length-1]) {
                int index = Arrays.binarySearch(arr, target);
                if (index >= 0) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().searchMatrix(
                new int[][]{
                        {1, 4, 7, 11, 15},
                        {2, 5, 8, 12, 19},
                        {3, 6, 9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}
                },
                5
        ));
    }
}
