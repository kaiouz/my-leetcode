package offer09;

import java.util.Deque;
import java.util.LinkedList;

class CQueue {

    private Deque<Integer> in = new LinkedList<>();
    private Deque<Integer> out = new LinkedList<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        Integer v = out.pollFirst();
        if (v == null) {
            while ((v = in.pollFirst()) != null) {
                out.push(v);
            }
            v = out.pollFirst();
        }
        return v == null ? -1 : v;
    }

}
