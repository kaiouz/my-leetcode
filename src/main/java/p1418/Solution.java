package p1418;

import java.util.*;

class Solution {

    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<String, Integer>[] tables = new Map[501];
        Set<String> foods = new TreeSet<>();

        for (List<String> order : orders) {
            int table = Integer.parseInt(order.get(1));
            String food = order.get(2);
            if (tables[table] == null) {
                tables[table] = new HashMap<>();
            }
            int count = tables[table].getOrDefault(food, 0) + 1;
            tables[table].put(food, count);
            foods.add(food);
        }

        List<List<String>> ans = new LinkedList<>();
        List<String> title = new LinkedList<>();
        title.add("Table");
        for (String food : foods) {
            title.add(food);
        }
        ans.add(title);
        for (int i = 0; i < tables.length; i++) {
            if (tables[i] != null) {
                List<String> order = new ArrayList<>();
                order.add(Integer.toString(i));
                for (String food : foods) {
                    order.add(Integer.toString(tables[i].getOrDefault(food, 0)));
                }
                ans.add(order);
            }
        }
        return ans;
    }

}
