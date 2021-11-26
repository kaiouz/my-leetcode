package p981;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TimeMap {

    private Map<String, List<Item>> values;

    /** Initialize your data structure here. */
    public TimeMap() {
        values = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Item> items = values.computeIfAbsent(key, k -> new ArrayList<>());
        items.add(new Item(value, timestamp));
    }

    public String get(String key, int timestamp) {
        List<Item> items = values.get(key);
        if (items == null || items.isEmpty()) {
            return "";
        }

        int left = 0, right = items.size();
        int pivot = left;
        while (left < right) {
            pivot = (left + right) / 2;
            Item item = items.get(pivot);
            if (item.timestamp >= timestamp) {
                right = pivot;
            } else {
                left = pivot + 1;
            }
        }
        if (right == 0) {
            return items.get(0).timestamp == timestamp ? items.get(0).value : "";
        } else if (right == items.size()) {
            return items.get(items.size() - 1).value;
        } else {
            return items.get(right).timestamp == timestamp ? items.get(right).value : items.get(right - 1).value;
        }
    }

    static class Item {
        String value;
        int timestamp;

        public Item(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
