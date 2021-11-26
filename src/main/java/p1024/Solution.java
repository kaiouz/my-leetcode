package p1024;

import java.util.Arrays;

class Solution {


    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, (o1, o2) -> {
            int v = Integer.compare(o1[0], o2[0]);
            if (v == 0) {
                return Integer.compare(o1[1], o2[1]);
            }
            return v;
        });

        int end = 0;
        int maxCurEnd = end;
        int piece = 1;

        for (int i = 0; i < clips.length; i++) {
            if (clips[i][0] <= end) {
                maxCurEnd = Math.max(maxCurEnd, clips[i][1]);
                if (maxCurEnd >= T) {
                    return piece;
                }
            } else {
                if (clips[i][0] <= maxCurEnd) {
                    piece++;
                    end = maxCurEnd;
                    maxCurEnd = clips[i][1];
                    if (maxCurEnd >= T) {
                        return piece;
                    }
                } else {
                    return -1;
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().videoStitching(new int[][] {
                {0,4},{2,8}
        }, 5));
    }
}
