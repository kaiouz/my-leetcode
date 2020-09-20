package p5508;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int numTriplets(int[] nums1, int[] nums2) {
        int count = 0;

        Map<Long, Integer> cache1 = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            for (int j = i + 1; j < nums1.length; j++) {
                cache1.compute((long) nums1[i] * (long) nums1[j], (k, v) -> {
                    return v == null ? 1 : v + 1;
                });
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            count += cache1.getOrDefault((long) nums2[i] * (long) nums2[i], 0);
        }

        Map<Long, Integer> cache2 = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            for (int j = i + 1; j < nums2.length; j++) {
                cache2.compute((long) nums2[i] * (long) nums2[j], (k, v) -> {
                    return v == null ? 1 : v + 1;
                });
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            count += cache2.getOrDefault((long) nums1[i] * (long) nums1[i], 0);
        }

        return count;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().numTriplets(new int[]{4,7,9,11,23}, new int[]{3,5,1024,12,18}));
    }
}
