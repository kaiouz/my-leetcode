package p77;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> temp = new ArrayList<>(k);
        for (int i = 0; i< k; i++) {
            temp.add(0);
        }
        helper(1, n, temp, 0, result);
        return result;
    }

    private void helper(int start, int end, List<Integer> temp, int index, List<List<Integer>> result) {
        int left = temp.size() - index;
        if (left <= 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i <= end - left + 1; i++) {
            temp.set(index, i);
            helper(i + 1, end, temp, index + 1, result);
        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution().combine(4, 2));
    }
}
