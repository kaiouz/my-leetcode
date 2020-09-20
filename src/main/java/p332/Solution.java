package p332;

import java.util.*;

class Solution {

    static class Des {
        public Des(String name) {
            this.name = name;
        }

        boolean arrive;
        String name;
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<Des>> paths = new HashMap<>();

        for (List<String> tick : tickets) {
            paths.computeIfAbsent(tick.get(0), k -> new ArrayList<>()).add(new Des(tick.get(1)));
        }

        for (List<Des> deses : paths.values()) {
            deses.sort(Comparator.comparing(v -> v.name));
        }

        List<String> path = new ArrayList<>();

        helper(paths, path, "JFK");
        return path;
    }

    private boolean helper(Map<String, List<Des>> paths, List<String> path, String next) {
        if (next == null) {
            for (List<Des> deses : paths.values()) {
                for (Des des : deses) {
                    if (!des.arrive) {
                        return false;
                    }
                }
            }
            return true;
        }

        path.add(next);

        List<Des> deses = paths.get(next);

        boolean hasPath = false;
        boolean success = false;

        if (deses != null) {
            for (Des des : deses) {
                if (!des.arrive) {
                    hasPath = true;

                    des.arrive = true;

                    success = helper(paths, path, des.name);

                    if (!success) {
                        des.arrive = false;
                    }
                }
            }
        }

        if (!hasPath) {
            success = helper(paths, path, null);
        }

        if (!success) {
            path.remove(path.size() - 1);
        }

        return success;
    }


}
