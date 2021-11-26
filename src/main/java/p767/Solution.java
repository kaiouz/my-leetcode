package p767;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

class Solution {

    public String reorganizeString(String S) {
        PriorityQueue<Item> items = new PriorityQueue<>(Comparator.<Item>comparingInt(it -> it.count).reversed());
        Map<Integer, Long> count = S.chars().boxed().collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        count.forEach((k, v) -> {
            items.add(new Item((char)k.intValue(), v.intValue()));
        });

        StringBuilder sb = new StringBuilder(S.length());


        while (!items.isEmpty()) {
           Item top = items.poll();

            if (sb.length() > 0 && top.c == sb.charAt(sb.length() - 1)) {
                Item item = items.poll();
                if (item == null) {
                    return "";
                }
                sb.append(item.c);
                if (--item.count > 0) {
                    items.add(item);
                }
            } else {
                sb.append(top.c);
                --top.count;
            }
            if (top.count > 0) {
                items.add(top);
            }
        }

        return sb.toString();
    }

    static class Item {
        char c;
        int count;

        public Item(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reorganizeString("aaab"));
    }

}
