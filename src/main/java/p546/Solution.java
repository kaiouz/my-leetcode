package p546;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    private Map<String, Integer> cache = new HashMap<>();

    public int removeBoxes(int[] boxes) {
        if (boxes.length == 0) {
            return 0;
        }

        int id = 0;
        int l = 0, r = 0;
        Map<Integer, Integer> idMap = new HashMap<>();
        StringBuilder idsb = new StringBuilder();
        List<int[]> removeIndex = new ArrayList<>();

        while (r < boxes.length || l < boxes.length) {
            if (r >= boxes.length || boxes[r] != boxes[l]) {
                int nextId = idMap.getOrDefault(boxes[l], -1);
                if (nextId == -1) {
                    nextId = id++;
                    idMap.put(boxes[l], nextId);
                }
                idsb.append(nextId).append('*').append(r-l).append('+');
                removeIndex.add(new int[]{l, r});
                l = r;
            }
            r++;
        }
        String hash = idsb.toString();

        if (cache.containsKey(hash)) {
            return cache.get(hash);
        }

        int max = 0;
        for (int[] next : removeIndex) {
            int score = next[1] - next[0];
            max = Math.max(removeBoxes(slice(boxes, next[0], next[1])) + score * score, max);
        }
        cache.put(hash, max);

        return max;
    }

    private int[] slice(int[] boxes, int l, int r) {
        int[] result = new int[boxes.length - (r - l)];
        System.arraycopy(boxes, 0, result, 0, l);
        System.arraycopy(boxes, r, result, l, boxes.length - r);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeBoxes(new int[] {3,8,8,5,5,3,9,2,4,4,6,5,8,4,8,6,9,6,2,8,6,4,1,9,5,3,10,5,3,3,9,8,8,6,5,3,7,4,9,6,3,9,4,3,5,10,7,6,10,7}));
    }
}
