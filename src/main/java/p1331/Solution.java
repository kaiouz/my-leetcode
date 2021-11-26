package p1331;

import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public int[] arrayRankTransform(int[] arr) {
        Item[] items = new Item[arr.length];
        for (int i = 0; i < arr.length; i++) {
            items[i] = new Item(arr[i]);
        }
        Item[] copy = Arrays.copyOf(items, items.length);
        Arrays.sort(items, Comparator.comparingInt(o -> o.value));
        int index = 1;
        if (arr.length > 0) {
            items[0].index = 1;
        }
        for (int i = 1; i < items.length; i++) {
            if (items[i].value == items[i-1].value) {
                items[i].index = index;
            } else {
                items[i].index = ++index;
            }
        }
        return Arrays.stream(copy).mapToInt(it -> it.index).toArray();
    }

    static class Item {
        int value;
        int index;

        public Item(int value) {
            this.value = value;
        }
    }

}
