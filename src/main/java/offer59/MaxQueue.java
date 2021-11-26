package offer59;

import java.util.LinkedList;

class MaxQueue {

    LinkedList<Integer> max;
    LinkedList<Integer> queue;

    public MaxQueue() {
        max = new LinkedList<>();
        queue = new LinkedList<>();
    }

    public int max_value() {
        Integer r = max.peekFirst();
        return r == null ? -1 : r;
    }

    public void push_back(int value) {
        queue.addLast(value);

        while (!max.isEmpty() && max.peekLast() < value) {
            max.pollLast();
        }
        max.addLast(value);
    }

    public int pop_front() {
        Integer r = queue.pollFirst();
        if (r == null) {
            return -1;
        }
        if (max.peekFirst().equals(r)) {
            max.pollFirst();
        }
        return r;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
