package p1395;

class Solution {
    public int numTeams(int[] rating) {
        int ans = 0;

        for (int i = 0; i < rating.length; i++) {
            for (int j = i + 1; j < rating.length; j++) {

                if (rating[i] < rating[j]) {
                    for (int k = j + 1; k < rating.length; k++) {
                        if (rating[j] < rating[k]) {
                            ans++;
                        }
                    }
                } else if (rating[i] > rating[j]) {
                    for (int k = j + 1; k < rating.length; k++) {
                        if (rating[j] > rating[k]) {
                            ans++;
                        }
                    }
                }

            }
        }

        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().numTeams(new int[]{
                2, 5, 3, 4, 1
        }));
    }
}
