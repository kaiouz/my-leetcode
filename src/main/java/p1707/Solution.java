package p1707;

import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        Integer[] mIndex = new Integer[queries.length];
        for (int i = 0; i < mIndex.length; i++) {
            mIndex[i] = i;
        }

        Arrays.sort(mIndex, Comparator.comparingInt(index -> queries[index][1]));

        int[] ans = new int[queries.length];
        int max = -1;
        int ni = 0;

        for (int i : mIndex) {
            while (ni < nums.length && nums[ni] <= queries[i][1]) {
                max = nums[ni];
                ni++;
            }
            if (max == -1) {
                ans[i] = -1;
            } else {
                ans[i] = queries[i][0] ^ max;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().maximizeXor(new int[]{0, 1, 2, 3, 4}, new int[][]{
                {3, 1},
                {1, 3},
                {5, 6}
        })));
    }

}
