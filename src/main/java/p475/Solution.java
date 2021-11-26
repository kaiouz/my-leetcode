package p475;

import java.util.Arrays;

class Solution {

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);

        int max = 0;

        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                index = -index - 1;
                if (index == 0) {
                    max = Math.max(max, heaters[index] - house);
                } else if (index == heaters.length) {
                    max = Math.max(max, house - heaters[index - 1]);
                } else {
                    max = Math.max(max, Math.min(house - heaters[index - 1], heaters[index] - house));
                }
            }
        }

        return max;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().findRadius(new int[]{1, 2, 3}, new int[]{2}));
    }
}
