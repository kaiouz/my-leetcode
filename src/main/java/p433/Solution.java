package p433;

import java.util.*;

class Solution {

    public int minMutation(String start, String end, String[] bank) {
        Map<String, List<String>> map = new HashMap<>();

        LinkedList<String> queue = new LinkedList<>();

        for (int i = 0; i < bank.length; i++) {
            if (diff(bank[i], start) == 1) {
                queue.offerLast(bank[i]);
            }
            for (int j = i + 1; j < bank.length; j++) {
                if (diff(bank[i], bank[j]) == 1) {
                    map.computeIfAbsent(bank[i], (k) -> new LinkedList<>()).add(bank[j]);
                    map.computeIfAbsent(bank[j], (k) -> new LinkedList<>()).add(bank[i]);
                }
            }
        }

        Set<String> visited = new HashSet<>();
        int level = 1;

        int size = 0;
        while ((size = queue.size()) > 0) {
            for (int i = 0; i < size; i++) {
                String s = queue.pollFirst();
                if (end.equals(s)) {
                    return level;
                }
                if (!visited.add(s)) {
                    continue;
                }
                for (String b : map.getOrDefault(s, Collections.emptyList())) {
                    if (!visited.contains(b)) {
                        queue.offerLast(b);
                    }
                }
            }
            level++;
        }

        return -1;
    }



    private int diff(String a, String b) {
        int count = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (++count > 1) {
                    break;
                }
            }
        }

        return count;
    }
}
