package p5512;

import java.util.HashSet;
import java.util.Set;

class Solution {

    private int sum = 0;

    private boolean[] sadp;


    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        sadp = new boolean[n];
        for (int i = 0; i < pairs.length; i++) {
            for (int j = i+1; j < pairs.length; j++) {
                sad(preferences, pairs[i], pairs[j]);
                sad(preferences, pairs[j], pairs[i]);
            }
        }

        return sum;
    }

    private void sad(int[][] preferences, int[] p1, int[] p2) {

        if (sad(preferences, p1[0], p1[1], p2[0]) && sad(preferences, p2[0], p2[1], p1[0])) {
            if (!sadp[p1[0]]) {
                sadp[p1[0]] = true;
                sum++;
            }
        } else if (sad(preferences, p1[0], p1[1], p2[1]) && sad(preferences, p2[1], p2[0], p1[0])){
            if (!sadp[p1[0]]) {
                sadp[p1[0]] = true;
                sum++;
            }
        }

        if (sad(preferences, p1[1], p1[0], p2[0]) && sad(preferences, p2[0], p2[1], p1[1])) {
            if (!sadp[p1[1]]) {
                sadp[p1[1]] = true;
                sum++;
            }
        } else if (sad(preferences, p1[1], p1[0], p2[1]) && sad(preferences, p2[1], p2[0], p1[1])){
            if (!sadp[p1[1]]) {
                sadp[p1[1]] = true;
                sum++;
            }
        }
    }

    private boolean sad(int[][] preferences, int x, int y, int u) {
        int[] s = preferences[x];
        boolean findY = false;

        for (int i = 0; i < s.length; i++) {
            if (s[i] == y) {
                findY = true;
            }
            if (s[i] == u) {
                return !findY;
            }
        }

        return false;
    }

}
