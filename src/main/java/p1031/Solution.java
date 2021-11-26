package p1031;

class Solution {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int LM = L + M;
        L = Math.min(L, M);
        M = LM - L;

        int sumL = 0;
        for (int i = 0; i < L; i++) {
            sumL += A[i];
        }

        int sumM = sumL;
        for (int i = L; i < M; i++) {
            sumM += A[i];
        }

        int sumLM = sumM;
        for (int i = M; i < LM; i++) {
            sumLM += A[i];
        }

        int ans = sumLM;
        int maxLL = sumL, curLL = sumL, curLM = sumLM - sumL;
        int maxMM = sumM,curMM = sumM, curML = sumLM - sumM;

        for (int i = LM; i < A.length; i++) {
            curLM = curLM + A[i] - A[i - M];
            curLL = curLL + A[i - M] - A[i - M - L];
            maxLL = Math.max(maxLL, curLL);
            ans = Math.max(ans, curLM + maxLL);

            curML = curML + A[i] - A[i - L];
            curMM = curMM + A[i - L] - A[i - M - L];
            maxMM = Math.max(maxMM, curMM);
            ans = Math.max(ans, curML + maxMM);
        }

        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().maxSumTwoNoOverlap(new int[]{0,6,5,2,2,5,1,9,4}, 1, 2));
    }
}
