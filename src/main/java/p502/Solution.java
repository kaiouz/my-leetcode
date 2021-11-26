package p502;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Item[] items = new Item[profits.length];
        for (int i = 0; i < profits.length; i++) {
            items[i] = new Item(profits[i], capital[i]);
        }
        Arrays.sort(items, Comparator.comparingInt(it -> it.capital));

        PriorityQueue<Item> heap = new PriorityQueue<>(Comparator.<Item>comparingInt(it -> it.profit).reversed());
        int ans = w;
        int j = 0;
        for (int i = 0; i < k; i++) {
            while (j < items.length && items[j].capital <= ans) {
                heap.add(items[j++]);
            }
            Item item = heap.poll();
            if (item == null) {
                break;
            }
            ans += item.profit;
        }

        return ans;
    }


    private static class Item {
        int profit;
        int capital;

        public Item(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }
}
