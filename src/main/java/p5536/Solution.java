package p5536;

import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public int maximalNetworkRank(int n, int[][] roads) {
        Set<Integer>[] paths = new Set[n];
        Map<Integer, Integer> size = new HashMap<>();

        for (int[] p : roads) {
            if (paths[p[0]] == null) {
                paths[p[0]] = new HashSet<>();
            }
            paths[p[0]].add(p[1]);

            if (paths[p[1]] == null) {
                paths[p[1]] = new HashSet<>();
            }
            paths[p[1]].add(p[0]);

            size.compute(p[0], (k, v) -> v == null ? 1 : v + 1);
            size.compute(p[1], (k, v) -> v == null ? 1 : v + 1);
        }

        List<Map.Entry<Integer, Integer>> du = size.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .collect(Collectors.toList());

        int max = 0;

        for (int i = 0; i < du.size(); i++) {
            for (int j = i + 1; j < du.size(); j++) {
                int num = du.get(i).getValue() + du.get(j).getValue();
                if (paths[du.get(i).getKey()].contains(du.get(j).getKey())) {
                    num--;
                }
                max = Math.max(max, num);
            }
        }

        return max;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().maximalNetworkRank(8, new int[][]{
                {0, 1}, {1, 2}, {2, 3}, {2, 4}, {5, 6}, {5, 7}
        }));
    }

}
