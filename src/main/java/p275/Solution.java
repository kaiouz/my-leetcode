package p275;

class Solution {
    public int hIndex(int[] citations) {
        int l = 0;
        int r = citations.length;

        int mid = 0;
        int max = 0;

        while (l <= r) {
            mid = (l + r) / 2;
            if (mid > 0 && citations[citations.length - mid] < mid) {
                r = mid - 1;
            } else if (mid  < citations.length && citations[citations.length - mid - 1] > mid) {
                l = mid + 1;
            } else {
               return mid;
            }
        }

        return max;
    }
}
