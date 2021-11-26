package p349;

import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (int n : nums1) {
            set1.add(n);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (int n : nums2) {
            set2.add(n);
        }

        set1.retainAll(set2);
        return set1.stream().mapToInt(Integer::intValue).toArray();
    }
}
