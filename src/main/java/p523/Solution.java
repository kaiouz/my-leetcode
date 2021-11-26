package p523;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public boolean checkSubarraySum(int[] nums, int k) {
        if (k < 0) {
            k = -k;
        }
        int sum = 0;
        int[] sumPrev = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sumPrev[i] = sum;
            if (k == 0) {
                if (i > 0 && sum == 0) {
                    return true;
                }
                for (int j = 0; j < i - 1; j++) {
                    if (sum == sumPrev[j]) {
                        return true;
                    }
                }
            } else {
                if (i > 0 && sum % k == 0) {
                    return true;
                }
                for (int j = 0; j < i - 1; j++) {
                    if ((sum - sumPrev[j]) % k == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 0));
    }

}
