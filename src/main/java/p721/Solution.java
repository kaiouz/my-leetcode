package p721;

import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashSet<Set<String>> ans = new HashSet<>();

        Map<String, Set<String>> cache = new HashMap<>();

        for (List<String> account : accounts) {
            int i = 0;

            Set<String> exist = null;

            for (String email : account) {
                if (i++ != 0) {
                    if (cache.containsKey(email)) {
                        exist = cache.get(email);
                        break;
                    }
                }
            }

            if (exist != null) {
                i = 0;
                for (String email : account) {
                    if (i++ != 0) {
                        exist.add(email);
                    }
                }
            } else {
                exist = new TreeSet<>(account);
                ans.add(exist);
            }

            i = 0;
            for (String email : account) {
                if (i++ != 0) {
                    cache.put(email, exist);
                }
            }
        }

        return ans.stream()
                .map(ArrayList::new)
                .collect(Collectors.toList());
    }

}
