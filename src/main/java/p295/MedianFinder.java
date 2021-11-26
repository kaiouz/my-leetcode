package p295;

import java.util.*;

class MedianFinder {

    private ArrayList<Integer> list;

    /** initialize your data structure here. */
    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
    }

    public double findMedian() {
        Collections.sort(list, Comparator.comparingInt(it -> it));
        int size = list.size();
        int mid = (size + 1) / 2;
        double ans = list.get(mid - 1);
        if (size % 2 == 0) {
            ans += list.get(mid);
            ans /= 2.0;
        }
        return ans;
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
