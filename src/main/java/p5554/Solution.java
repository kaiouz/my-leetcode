package p5554;

import java.util.*;

class Solution {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] piece : pieces) {
            map.put(piece[0], piece);
        }

        int i = 0;
        while (i < arr.length) {
            int[] piece = map.get(arr[i]);

            if (piece == null) {
                return false;
            }

            if (isValid(arr, i, piece)) {
                i += piece.length;
            } else {
                return false;
            }
        }

        return true;
    }


    private boolean isValid(int[] arr, int i, int[] piece) {
        int len = arr.length - i;
        if (len < piece.length) {
            return false;
        }

        for (int j = 0; j < piece.length; j++) {
            if (piece[j] != arr[j + i]) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().canFormArray(new int[]{15, 88}, new int[][]{
                {88},
                {15}
        }));
    }
}
