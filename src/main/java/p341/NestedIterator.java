package p341;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {

    LinkedList<Iterator<NestedInteger>> stack = new LinkedList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        stack.offerLast(nestedList.iterator());
    }

    @Override
    public Integer next() {
        return stack.peekLast().next().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            if (stack.peekLast().hasNext()) {
                NestedInteger ni = stack.peekLast().next();
                if (ni.isInteger()) {
                    stack.offerLast(Arrays.asList(ni).iterator());
                    return true;
                } else {
                    stack.offerLast(ni.getList().iterator());
                }
            } else {
                stack.pollLast();
            }
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
