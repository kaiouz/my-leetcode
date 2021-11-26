package p852;

class Solution {

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length;
        int pivot = left;

        while (left < right) {
            pivot = (left + right) / 2;
            if (pivot > 1 && pivot < arr.length - 1
                    && arr[pivot] > arr[pivot - 1]
                    && arr[pivot] > arr[pivot + 1]) {
                return pivot;
            } else if (pivot < 1 || arr[pivot] > arr[pivot - 1]) {
                left = pivot + 1;
            } else if (pivot >= arr.length - 1 || arr[pivot] > arr[pivot + 1]) {
                right = pivot;
            }
        }

        return 1;
    }


}
