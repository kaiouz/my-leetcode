package p1116;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private final int n;
    ReentrantLock lock = new ReentrantLock();
    Condition zero = lock.newCondition();
    Condition even = lock.newCondition();
    Condition odd = lock.newCondition();

    private int next = 0;
    private int state = 0;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            for (int i = 1; i <= n; i++) {
                while (state != 0) {
                    zero.await();
                }
                printNumber.accept(0);
                next = i;
                if (i % 2 == 0) {
                    state = 2;
                    even.signal();
                } else {
                    state = 1;
                    odd.signal();
                }
            }
            zero.await();
            state = -1;
            even.signal();
            odd.signal();
        } finally {
            lock.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            for (;;) {
                while (state != 2) {
                    if (state == -1) {
                        return;
                    }
                    even.await();
                }
                printNumber.accept(next);
                state = 0;
                zero.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            for (;;) {
                while (state != 1) {
                    if (state == -1) {
                        return;
                    }
                    odd.await();
                }
                printNumber.accept(next);
                state = 0;
                zero.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        IntConsumer intConsumer = System.out::println;
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(10);
        new Thread(() -> {
            try {
                zeroEvenOdd.zero(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.even(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.odd(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
