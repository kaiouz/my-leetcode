package p5489;

import java.util.Arrays;

class Solution {

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int l = 1, r = (position[position.length - 1] - position[0]) / (m - 1) + 1;
        int result = 0;
        while (l < r) {
            int mid = (l + r) / 2;
            if (isOk(position, m, mid)) {
                l = mid + 1;
                result = mid;
            } else {
                r = mid;
            }
        }
        return result;
    }

    private boolean isOk(int[] position, int m, int target) {
        int l = 0, r = 0;

        while (r < position.length && m > 1) {
            if (position[r] - position[l] >= target) {
                l = r;
                m--;
            }
            r++;
        }

        return m == 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxDistance(new int[]{1,2,3,4,5,6,7,8,9,10},
        4));
    }
}
