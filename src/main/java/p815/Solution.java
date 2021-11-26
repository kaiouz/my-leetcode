package p815;

import java.util.*;

class Solution {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        Map<Integer, Set<Integer>> stationToBus = new HashMap<>();
        Map<Integer, Set<Integer>> busToStation = new HashMap<>();

        Set<Integer> targetBus = new HashSet<>();

        for (int bus = 0; bus < routes.length; bus++) {
            for (int station = 0; station < routes[bus].length; station++) {
                stationToBus.computeIfAbsent(routes[bus][station], key -> new HashSet<>()).add(bus);
                busToStation.computeIfAbsent(bus, key -> new HashSet<>()).add(routes[bus][station]);
                if (routes[bus][station] == target) {
                    targetBus.add(bus);
                }
            }
        }

        if (targetBus.isEmpty()) {
            return -1;
        }

        Map<Integer, Set<Integer>> busToBus = new HashMap<>();
        for (Map.Entry<Integer, Set<Integer>> entry : busToStation.entrySet()) {
            Set<Integer> buses = busToBus.computeIfAbsent(entry.getKey(), key -> new HashSet<>());
            for (Integer station : entry.getValue()) {
                buses.addAll(stationToBus.get(station));
            }
        }

        Set<Integer> visited = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<>(stationToBus.get(source));

        int step = 1;

        int size = 0;
        while ((size = queue.size()) > 0) {

            for (int i = 0; i < size; i++) {
                int bus = queue.removeFirst();
                if (targetBus.contains(bus)) {
                    return step;
                }

                for (int b : busToBus.get(bus)) {
                    if (visited.add(b)) {
                        queue.addLast(b);
                    }
                }
            }

            step++;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numBusesToDestination(new int[][]
                {{1,9,12,20,23,24,35,38},{10,21,24,31,32,34,37,38,43},{10,19,28,37},{8},{14,19},{11,17,23,31,41,43,44},{21,26,29,33},{5,11,33,41},{4,5,8,9,24,44}}
        , 37, 28));
    }
}
