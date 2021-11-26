package ms0105;

class Solution {

//    public boolean oneEditAway(String first, String second) {
//        int m = first.length();
//        int n = second.length();
//
//        int[][] dp = new int[m + 1][n + 1];
//
//        for (int i = 1; i <= m; i++) {
//            dp[i][0] = i;
//        }
//
//        for (int i = 1; i <= n; i++) {
//            dp[0][i] = i;
//        }
//
//        for (int i = 1; i <= m; i++) {
//            for (int j = 1; j <= n; j++) {
//                if (first.charAt(i - 1) == second.charAt(j - 1)) {
//                    dp[i][j] = dp[i - 1][j - 1];
//                } else {
//                    dp[i][j] = dp[i - 1][j - 1] + 1;
//                }
//                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
//                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
//            }
//        }
//
//        return dp[m][n] <= 1;
//    }

    public boolean oneEditAway(String first, String second) {
        int len = first.length() - second.length();

        int[] type = new int[]{1, 1};
        if (len < - 1 || len > 1) {
            return false;
        } else if (len > 0) {
            type[1] = 0;
        } else if (len < 0) {
            type[0] = 0;
        }

        int i = 0;
        int j = 0;
        boolean repair = false;

        while (i < first.length() && j < second.length()) {
            if (first.charAt(i) == second.charAt(j)) {
                i++;
                j++;
            } else {
                if (!repair) {
                    repair = true;
                    i += type[0];
                    j += type[1];
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
