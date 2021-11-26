package p1366;

import java.util.Arrays;

class Solution {
    public String rankTeams(String[] votes) {
        int count = votes[0].length();
        int[][] voteCount = new int[26][];

        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                int index = vote.charAt(i) - 'A';
                if (voteCount[index] == null) {
                    voteCount[index] = new int[count+1];
                    voteCount[index][count] = index;
                }
                voteCount[index][i]++;
            }
        }

        Arrays.sort(voteCount, this::compare);

        char[] chars = new char[count];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (voteCount[i][count] + 'A');
        }

        return new String(chars);
    }

    private int compare(int[] a, int[] b) {
        if (a == null && b == null) {
            return 0;
        } else if (a == null) {
            return 1;
        } else if (b == null) {
            return -1;
        } else {
            int last = a.length - 1;
            for (int i = 0; i < last; i++) {
                if (a[i] > b[i]) {
                    return -1;
                } else if (a[i] < b[i]) {
                    return 1;
                }
            }
            return a[last] - b[last];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rankTeams(new String[] {"ABC","ACB","ABC","ACB","ACB"}));
    }
}
