package p1423;

class Solution {

    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;

        int start = cardPoints.length - k;
        for (int i = start; i < cardPoints.length; i++) {
            sum += cardPoints[i];
        }
        int max = sum;
        for (int l = 0, r = start; r < cardPoints.length; r++,l++) {
            sum = sum - cardPoints[r] + cardPoints[l];
            max = Math.max(max, sum);
        }

        return max;
    }


}
