package p78;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>((int)Math.pow(2, nums.length));
        ans.add(Collections.emptyList());

        for (int n : nums) {
            List<List<Integer>> cur = new ArrayList<>(ans.size());
            for (List<Integer> list : ans) {
                List<Integer> l = new ArrayList(list.size() + 1);
                l.addAll(list);
                l.add(n);
                cur.add(l);
            }
            ans.addAll(cur);
        }

        return ans;
    }
}
