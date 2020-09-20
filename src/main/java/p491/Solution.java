package p491;

import java.util.*;

class Solution {

    public List<List<Integer>> findSubsequences(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> list = new LinkedList<>();

        int i = 0;
        int len = 1;

        while (i < nums.length) {
            len = 1;
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                i++;
                len++;
            }

            List<List<Integer>> sl = new ArrayList<>();

            for (int k = 1; k <= len; k++) {
                for (List<Integer> l : list) {
                    List<Integer> list1 = new ArrayList<>(l.size() + k);
                    list1.addAll(l);
                    for (int j = 0; j < k; j++) {
                        list1.add(nums[i]);
                    }
                    sl.add(list1);
                }

                List<Integer> list1 = new ArrayList<>(k);
                for (int j = 0; j < k; j++) {
                    list1.add(nums[i]);
                }
                sl.add(list1);
            }

            list.addAll(sl);
            i++;
        }

        list.removeIf(integers -> integers.size() <= 1);

        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findSubsequences(new int[]{4,6,7,7}));
    }
}
