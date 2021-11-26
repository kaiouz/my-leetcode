package p1300;

import java.util.Arrays;

class Solution {

    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);

        int[] sum = new int[arr.length];
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            s += arr[i];
            sum[i] = s;
        }

        int left = 0, right = arr[arr.length - 1];
        int pivot = left;
        int leftMost = left, rightMost = right;

        while (left <= right) {
            pivot = left + (right - left) / 2;
            int ret = computeSum(arr, sum, pivot);
            if (ret > target) {
                right = pivot - 1;
                rightMost = pivot;
            } else if (ret < target) {
                left = pivot + 1;
                leftMost = pivot;
            } else {
                return pivot;
            }
        }

        if (Math.abs(computeSum(arr, sum, leftMost) - target) <= Math.abs(computeSum(arr, sum, rightMost) - target)) {
            return leftMost;
        } else {
            return rightMost;
        }
    }


    private int computeSum(int[] arr, int[] sum, int val) {
        int index = Arrays.binarySearch(arr, val);
        if (index >= 0) {
            return sum[index] + (arr.length - index - 1) * val;
        } else {
            index = -index - 1;
            int s = 0;
            if (index > 0) {
                s += sum[index - 1];
            }
            s += (arr.length - index) * val;
            return s;
        }
    }
}
