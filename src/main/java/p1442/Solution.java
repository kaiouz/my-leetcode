package p1442;

import java.util.*;

class Solution {

    public int countTriplets(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        map.put(0, new LinkedList<>(Collections.singletonList(-1)));

        int sum = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            sum ^= arr[i];
            List<Integer> list = map.computeIfAbsent(sum, (key) -> new LinkedList<>());
            for (int index : list) {
                count += i - index - 1;
            }
            list.add(i);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countTriplets(new int[] {2, 3, 1, 6, 7}));
    }
}
