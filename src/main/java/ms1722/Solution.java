package ms1722;

import java.util.*;

class Solution {

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> cache = new HashMap<>();

        boolean noEnd = true;

        for (int i = 0; i < wordList.size(); i++) {
            String si = wordList.get(i);
            if (endWord.equals(si)) {
                noEnd = false;
            }
            for (int j = i + 1; j < wordList.size(); j++) {
                String sj = wordList.get(j);
                if (converted(si, sj) == 1) {
                    cache.computeIfAbsent(si, k -> new HashSet<>()).add(sj);
                    cache.computeIfAbsent(sj, k -> new HashSet<>()).add(si);
                }
            }
        }

        if (!noEnd) {
            LinkedList<String> path = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            path.add(beginWord);

            for (String key : cache.keySet()) {
                if (converted(key, beginWord) == 1) {
                    path.addLast(key);
                    if (dfs(path, cache, visited, key, endWord)) {
                        return path;
                    }
                    path.removeLast();
                }
            }

        }

        return Collections.emptyList();
    }

    private boolean dfs(LinkedList<String> path, Map<String, Set<String>> cache, Set<String> visited, String key, String end) {
        if (key.equals(end)) {
            return true;
        }

        if (visited.contains(key)) {
            return false;
        } else {
            visited.add(key);
        }

        Set<String> nexts = cache.getOrDefault(key, Collections.emptySet());
        for (String next : nexts) {
            path.addLast(next);
            if (dfs(path, cache, visited, next, end)) {
                return true;
            }
            path.pollLast();
        }

        return false;
    }

    private int converted(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
                if (diff > 1) {
                    break;
                }
            }
        }
        return diff;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().converted("hot", "dog"));
        System.out.println(new Solution().findLadders("hit",
                "cog",
                        Arrays.asList("hot","dot","dog","lot","log","cog")));
    }


}
