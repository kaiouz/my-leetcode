package p1985;

import java.util.PriorityQueue;

class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> heap = new PriorityQueue<>((a, b) -> {
            int rt = Integer.compare(a.length(), b.length());
            if (rt == 0) {
                for (int i = 0; i < a.length(); i++) {
                    char ac = a.charAt(i);
                    char bc = b.charAt(i);
                    if (ac > bc) {
                        return 1;
                    } else if (ac < bc) {
                        return -1;
                    }
                }
                return 0;
            } else {
                return rt;
            }
        });

        for (String n: nums) {
            heap.add(n);
            if (heap.size() > k) {
                heap.remove();
            }
        }

        return heap.remove();
    }
}
