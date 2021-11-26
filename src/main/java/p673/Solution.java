package p673;

class Solution {

    public int findNumberOfLIS(int[] nums) {
        int[] count = new int[nums.length];
        int[] max = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            count[i] = 1;
            max[i] = 1;

            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    int len = max[j] + 1;
                    if (len > max[i]) {
                        max[i] = len;
                        count[i] = count[j];
                    } else if (len == max[i]) {
                        count[i] += count[j];
                    }
                }
            }
        }

        int maxLen = 0;
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max[i] > maxLen) {
                maxLen = max[i];
                maxCount = count[i];
            } else if (max[i] == maxLen) {
                maxCount += count[i];
            }
        }

        return maxCount;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));
    }
}
