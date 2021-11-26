package p1011;

class Solution {

    public int shipWithinDays(int[] weights, int D) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int weight : weights) {
            min = Math.min(min, weight);
            sum += weight;
        }

        int left = min, right = sum;
        int pivot = sum;

        int ans = sum;
        while (left <= right) {
            pivot = (left + right) / 2;
            if (withinDays(weights, D, pivot)) {
                right = pivot - 1;
                ans = pivot;
            } else {
                left = pivot + 1;
            }
        }

        return ans;
    }

    private boolean withinDays(int[] weights, int D, int bearer) {
        int sum = 0;
        int days = 1;

        for (int w : weights) {
            sum += w;
            if (sum > bearer) {
                days++;
                sum = w;
                if (sum > bearer) {
                    return false;
                }
                if (days > D) {
                    return false;
                }
            }
        }

        return days <= D;
    }
}
