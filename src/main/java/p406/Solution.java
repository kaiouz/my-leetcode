package p406;

import java.util.Arrays;

class Solution {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            int ret = Integer.compare(o1[0], o2[0]);
            return ret != 0 ? ret : Integer.compare(o2[1], o1[1]);
        });
        int[][] ans = new int[people.length][];

        for (int[] p : people) {
            int i = -1;
            int count = 0;
            while (count < p[1] + 1) {
                if (ans[++i] == null) {
                    count++;
                }
            }
            ans[i] = p;
        }

        return ans;
    }


}
