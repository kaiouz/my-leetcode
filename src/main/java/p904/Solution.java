package p904;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int totalFruit(int[] tree) {
        int ans = 0;

        int count = 0;
        Map<Integer, int[]> type = new HashMap<>();
        int l = 0;

        for (int i = 0; i < tree.length; i++) {
            type.computeIfAbsent(tree[i], k -> new int[1])[0]++;
            if (type.size() > 2) {
                ans = Math.max(ans, count);

                while (type.size() > 2) {
                    if (--type.get(tree[l])[0] == 0) {
                        type.remove(tree[l]);
                    }
                    l++;
                    count--;
                }
            }
            count++;
        }

        ans = Math.max(ans, count);

        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().totalFruit(new int[] {3,3,3,1,2,1,1,2,3,3,4}));
    }

}
