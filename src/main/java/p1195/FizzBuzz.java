package p1195;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class FizzBuzz {
    private final int n;

    private Semaphore number = new Semaphore(0);
    private Semaphore fizz = new Semaphore(0);
    private Semaphore buzz = new Semaphore(0);
    private Semaphore fizzbuzz = new Semaphore(0);

    private boolean stop;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (;;) {
            fizz.acquire();
            if (stop) {
                return;
            }
            printFizz.run();
            number.release();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (;;) {
            buzz.acquire();
            if (stop) {
                return;
            }
            printBuzz.run();
            number.release();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (;;) {
            fizzbuzz.acquire();
            if (stop) {
                return;
            }
            printFizzBuzz.run();
            number.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            boolean fizz = i % 3 == 0;
            boolean buzz = i % 5 == 0;

            if (fizz || buzz) {
                if (fizz && buzz) {
                    fizzbuzz.release();
                } else if (fizz) {
                    this.fizz.release();
                } else {
                    this.buzz.release();
                }
                number.acquire();
            } else {
                printNumber.accept(i);
            }
        }
        stop = true;
        fizz.release();
        buzz.release();
        fizzbuzz.release();
    }
}
