package p1052;

class Solution {

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int sum = 0;
        for (int i = 0; i < customers.length; i++) {
            if (i < X) {
                sum += customers[i];
            } else {
                sum += customers[i] * (1 - grumpy[i]);
            }
        }

        int max = sum;
        for (int l = 0, r = X; r < customers.length; l++,r++) {
            if (grumpy[r] == 1) {
                sum += customers[r];
            }
            if (grumpy[l] == 1) {
                sum -= customers[l];
            }
            max = Math.max(max, sum);
        }

        return max;
    }

}
