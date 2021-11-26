package p352;

import java.util.Arrays;

class SummaryRanges {

    int count = 0;

    Item[] items = new Item[10001];

    int[][] ret;

    public SummaryRanges() {

    }

    public void addNum(int val) {
        if (items[val] == null) {
            Item item = new Item(val);
            items[val] = item;

            if (val > 0) {
                item.prev = items[val - 1];
                if (item.prev != null) {
                    item.prev.next = item;
                }
            }

            if (val < items.length - 1) {
                item.next = items[val + 1];
                if (item.next != null) {
                    item.next.prev = item;
                }
            }

            if (item.prev == null && item.next == null) {
                count++;
            } else if (item.prev != null && item.next != null) {
                count--;
            }
            ret = null;
        }
    }

    public int[][] getIntervals() {
        if (ret == null) {
            ret = new int[count][2];
            int k = 0;
            for (Item item : items) {
                if (item != null && item.prev == null) {
                    int end = item.val;
                    Item p = item;
                    while (p != null) {
                        end = p.val;
                        p = p.next;
                    }
                    ret[k][0] = item.val;
                    ret[k][1] = end;
                    k++;
                }
            }
        }
        return ret;
    }

    static class Item {
        int val;
        Item prev;
        Item next;

        public Item(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        SummaryRanges summaryRanges = new SummaryRanges();
        summaryRanges.addNum(1);
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));

        summaryRanges.addNum(3);
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));

        summaryRanges.addNum(7);
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));

        summaryRanges.addNum(2);
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));

        summaryRanges.addNum(6);
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
