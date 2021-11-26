package p707;

class MyLinkedList {

    private int size;

    private ListNode head;
    private ListNode tail;


    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        head = new ListNode(Integer.MIN_VALUE);
        tail = new ListNode(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        ListNode p = head.next;
        while (index-- > 0) {
            p = p.next;
        }

        return p.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addNode(head, new ListNode(val));
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addNode(tail.prev, new ListNode(val));
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0) {
            addAtHead(val);
        } else if (index < size) {
            addNode(findNode(index), new ListNode(val));
        } else if (index == size) {
            addAtTail(val);
        }
    }

    private void addNode(ListNode p, ListNode node) {
        p.next.prev = node;
        node.next = p.next;
        node.prev = p;
        p.next = node;
        size++;
    }

    private void removeNode(ListNode p) {
        p.next = p.next.next;
        p.next.prev = p;
        size--;
    }

    private ListNode findNode(int index) {
        ListNode p;
        if (index < size - index) {
            p = head;
            while (index-- > 0) {
                p = p.next;
            }
        } else {
            p = tail;
            while (index++ <= size) {
                p = p.prev;
            }
        }
        return p;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        removeNode(findNode(index));
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        public ListNode(int val) {
            this.val = val;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
