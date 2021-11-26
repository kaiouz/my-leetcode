package offer30;

import java.util.LinkedList;
import java.util.Objects;

class MinStack {

    private LinkedList<Integer> stack;
    private LinkedList<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        stack.offerLast(x);
        if (minStack.isEmpty() || x <= minStack.peekLast()) {
            minStack.offerLast(x);
        }
    }

    public void pop() {
        Integer x = stack.pollLast();
        if (x != null && Objects.equals(minStack.peekLast(), x)) {
            minStack.pollLast();
        }
    }

    public int top() {
        return stack.peekLast();
    }

    public int min() {
        return minStack.peekLast();
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
