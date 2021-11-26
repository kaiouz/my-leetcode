package p1452;

import java.util.*;

class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> ans = new LinkedList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        int i = 0;

        for (List<String> companies : favoriteCompanies) {
            for (String company : companies) {
                List<Integer> set = map.computeIfAbsent(company, (k) -> new LinkedList<>());
                set.add(i);
            }
            i++;
        }

        i = 0;
        Set<Integer> set = new HashSet<>();
        for (List<String> companies : favoriteCompanies) {
            set.clear();

            Iterator<String> iterator = companies.iterator();
            set.addAll(map.get(iterator.next()));

            while (iterator.hasNext()) {
                set.retainAll(map.get(iterator.next()));
            }

            if (set.size() == 1) {
                ans.add(i);
            }

            i++;
        }

        return ans;
    }
}
